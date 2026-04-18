<template>
  <div class="page-container">
    <div class="page-header">
      <div>
        <div class="page-title">用户管理</div>
        <div class="page-subtitle">省级、市级、企业账号管理</div>
      </div>
      <el-button type="primary" @click="openDialog()">新增用户</el-button>
    </div>

    <el-card class="main-card">
      <el-table :data="list" border stripe style="width: 100%">
        <el-table-column prop="username" label="登录账号" width="180" />
        <el-table-column prop="realName" label="真实姓名" width="160" />
        <el-table-column prop="userType" label="用户类型" width="120" />
        <el-table-column prop="districtName" label="所属地区" width="140" />
        <el-table-column prop="enabled" label="启用" width="100" />
        <el-table-column label="操作" width="180">
          <template #default="{ row }">
            <el-button size="small" @click="openDialog(row)">编辑</el-button>
            <el-button size="small" type="danger" @click="remove(row.id)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <el-dialog v-model="visible" title="用户信息" width="680px">
      <el-form :model="form" label-width="120px">
        <el-form-item label="登录账号">
          <el-input v-model="form.username" />
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="form.password" type="password" show-password />
        </el-form-item>
        <el-form-item label="真实姓名">
          <el-input v-model="form.realName" />
        </el-form-item>
        <el-form-item label="用户类型">
          <el-select v-model="form.userType" placeholder="请选择">
            <el-option label="省级用户" value="PROVINCE" />
            <el-option label="市级用户" value="CITY" />
            <el-option label="企业用户" value="ENTERPRISE" />
          </el-select>
        </el-form-item>
        <el-form-item label="所属地区编码">
          <el-input v-model="form.districtCode" />
        </el-form-item>
        <el-form-item label="所属地区名称">
          <el-input v-model="form.districtName" />
        </el-form-item>
        <el-form-item label="启用">
          <el-switch v-model="form.enabled" />
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
  username: '',
  password: '',
  realName: '',
  userType: 'ENTERPRISE',
  districtCode: '',
  districtName: '',
  enabled: true
})

const load = async () => {
  list.value = await request.get('/user')
}

const openDialog = (row) => {
  editId.value = row?.id || null
  Object.assign(form, row || {
    username: '',
    password: '',
    realName: '',
    userType: 'ENTERPRISE',
    districtCode: '',
    districtName: '',
    enabled: true
  })
  visible.value = true
}

const save = async () => {
  if (editId.value) {
    await request.put(`/user/${editId.value}`, form)
  } else {
    await request.post('/user', form)
  }
  ElMessage.success('保存成功')
  visible.value = false
  await load()
}

const remove = async (id) => {
  await ElMessageBox.confirm('确认删除该用户吗？', '提示', { type: 'warning' })
  await request.delete(`/user/${id}`)
  ElMessage.success('删除成功')
  await load()
}

onMounted(load)
</script>