<template>
  <div class="page-container">
    <div class="page-header">
      <div>
        <div class="page-title">地区编码管理</div>
        <div class="page-subtitle">维护云南省地区编码数据</div>
      </div>
      <el-button type="primary" @click="openDialog()">新增地区</el-button>
    </div>

    <el-card class="main-card">
      <el-table :data="list" border stripe style="width: 100%">
        <el-table-column prop="code" label="地区编码" width="160" />
        <el-table-column prop="name" label="地区名称" />
        <el-table-column prop="parentCode" label="上级编码" width="160" />
        <el-table-column label="操作" width="160">
          <template #default="{ row }">
            <el-button size="small" @click="openDialog(row)">编辑</el-button>
            <el-button size="small" type="danger" @click="remove(row.id)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <el-dialog v-model="visible" title="地区编码" width="560px">
      <el-form :model="form" label-width="100px">
        <el-form-item label="地区编码">
          <el-input v-model="form.code" />
        </el-form-item>
        <el-form-item label="地区名称">
          <el-input v-model="form.name" />
        </el-form-item>
        <el-form-item label="上级编码">
          <el-input v-model="form.parentCode" />
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
import { createDistrictCode, deleteDistrictCode, getDistrictCodeList, updateDistrictCode } from '../../api/districtCode'

const list = ref([])
const visible = ref(false)
const editId = ref(null)

const form = reactive({
  code: '',
  name: '',
  parentCode: ''
})

const load = async () => {
  list.value = await getDistrictCodeList()
}

const openDialog = (row) => {
  editId.value = row?.id || null
  Object.assign(form, row || { code: '', name: '', parentCode: '' })
  visible.value = true
}

const save = async () => {
  if (editId.value) {
    await updateDistrictCode(editId.value, form)
  } else {
    await createDistrictCode(form)
  }
  ElMessage.success('保存成功')
  visible.value = false
  await load()
}

const remove = async (id) => {
  await ElMessageBox.confirm('确认删除该地区吗？', '提示', { type: 'warning' })
  await deleteDistrictCode(id)
  ElMessage.success('删除成功')
  await load()
}

onMounted(load)
</script>