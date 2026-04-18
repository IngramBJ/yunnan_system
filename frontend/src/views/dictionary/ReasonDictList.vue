<template>
  <div class="page-container">
    <div class="page-header">
      <div>
        <div class="page-title">就业失业原因字典</div>
        <div class="page-subtitle">维护原因描述与上级分类关系</div>
      </div>
      <el-button type="primary" @click="openDialog()">新增原因</el-button>
    </div>

    <el-card class="main-card">
      <el-table :data="list" border stripe style="width: 100%">
        <el-table-column prop="reasonDesc" label="原因描述" />
        <el-table-column prop="superReason" label="上级原因" width="220" />
        <el-table-column label="操作" width="160">
          <template #default="{ row }">
            <el-button size="small" @click="openDialog(row)">编辑</el-button>
            <el-button size="small" type="danger" @click="remove(row.id)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <el-dialog v-model="visible" title="原因字典" width="560px">
      <el-form :model="form" label-width="100px">
        <el-form-item label="原因描述">
          <el-input v-model="form.reasonDesc" />
        </el-form-item>
        <el-form-item label="上级原因">
          <el-input v-model="form.superReason" />
        </el-form-item>
      </el-form>

      <template #footer>
        <el-button @click="visible = false">取消</el-button>
        <el-button type="primary" @click="save">保存</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { onMounted, reactive, ref } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import request from '../../api/request'

const list = ref([])
const visible = ref(false)
const editId = ref(null)

const form = reactive({
  reasonDesc: '',
  superReason: ''
})

const load = async () => {
  list.value = await request.get('/reason-dict')
}

const openDialog = (row) => {
  editId.value = row?.id || null
  Object.assign(form, row || { reasonDesc: '', superReason: '' })
  visible.value = true
}

const save = async () => {
  if (editId.value) {
    await request.put(`/reason-dict/${editId.value}`, form)
  } else {
    await request.post('/reason-dict', form)
  }
  ElMessage.success('保存成功')
  visible.value = false
  await load()
}

const remove = async (id) => {
  await ElMessageBox.confirm('确认删除该原因吗？', '提示', { type: 'warning' })
  await request.delete(`/reason-dict/${id}`)
  ElMessage.success('删除成功')
  await load()
}

onMounted(load)
</script>