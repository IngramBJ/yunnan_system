<template>
  <div class="page-container">
    <div class="page-header">
      <div>
        <div class="page-title">角色管理</div>
        <div class="page-subtitle">角色定义与功能权限分配</div>
      </div>
      <el-button type="primary" @click="openDialog()">新增角色</el-button>
    </div>

    <el-card class="main-card">
      <el-table :data="list" border stripe style="width: 100%">
        <el-table-column prop="roleCode" label="角色编码" width="180" />
        <el-table-column prop="roleName" label="角色名称" />
        <el-table-column label="操作" width="160">
          <template #default="{ row }">
            <el-button size="small" @click="openDialog(row)">编辑</el-button>
            <el-button size="small" type="danger" @click="remove(row.id)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <el-dialog v-model="visible" title="角色信息" width="560px">
      <el-form :model="form" label-width="100px">
        <el-form-item label="角色编码">
          <el-input v-model="form.roleCode" placeholder="如：PROVINCE_ADMIN" />
        </el-form-item>
        <el-form-item label="角色名称">
          <el-input v-model="form.roleName" placeholder="请输入角色名称" />
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
  roleCode: '',
  roleName: ''
})

const load = async () => {
  list.value = await request.get('/role')
}

const openDialog = (row) => {
  editId.value = row?.id || null
  Object.assign(form, row || { roleCode: '', roleName: '' })
  visible.value = true
}

const save = async () => {
  if (editId.value) {
    await request.put(`/role/${editId.value}`, form)
  } else {
    await request.post('/role', form)
  }
  ElMessage.success('保存成功')
  visible.value = false
  await load()
}

const remove = async (id) => {
  await ElMessageBox.confirm('确认删除该角色吗？', '提示', { type: 'warning' })
  await request.delete(`/role/${id}`)
  ElMessage.success('删除成功')
  await load()
}

onMounted(load)
</script>