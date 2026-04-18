<template>
  <div class="page-container">
    <div class="page-header">
      <div>
        <div class="page-title">通知公告</div>
        <div class="page-subtitle">发布、查看、删除通知公告信息</div>
      </div>
      <el-button type="primary" @click="visible = true">发布通知</el-button>
    </div>

    <el-card class="main-card">
      <el-table :data="list" border stripe style="width: 100%">
        <el-table-column prop="title" label="标题" min-width="220" />
        <el-table-column prop="publisherName" label="发布单位" width="160" />
        <el-table-column prop="publishedAt" label="发布时间" width="220" />
        <el-table-column label="操作" width="120">
          <template #default="{ row }">
            <el-button size="small" type="danger" @click="remove(row.id)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <el-dialog v-model="visible" title="发布通知" width="760px">
      <el-form :model="form" label-width="100px">
        <el-form-item label="标题">
          <el-input v-model="form.title" maxlength="50" show-word-limit />
        </el-form-item>
        <el-form-item label="内容">
          <el-input v-model="form.content" type="textarea" :rows="10" maxlength="2000" show-word-limit />
        </el-form-item>
      </el-form>

      <template #footer>
        <el-button @click="visible = false">取消</el-button>
        <el-button type="primary" @click="save">发布</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { onMounted, reactive, ref } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { createNotice, deleteNotice, getNoticeList } from '../../api/notice'

const list = ref([])
const visible = ref(false)

const form = reactive({
  title: '',
  content: ''
})

const load = async () => {
  list.value = await getNoticeList()
}

const save = async () => {
  await createNotice(form, 1, '省级用户')
  ElMessage.success('发布成功')
  visible.value = false
  form.title = ''
  form.content = ''
  await load()
}

const remove = async (id) => {
  await ElMessageBox.confirm('确认删除该通知吗？', '提示', { type: 'warning' })
  await deleteNotice(id)
  ElMessage.success('删除成功')
  await load()
}

onMounted(load)
</script>