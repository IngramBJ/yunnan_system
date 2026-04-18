<template>
  <div class="page-container">
    <div class="page-header">
      <div>
        <div class="page-title">企业备案管理</div>
        <div class="page-subtitle">企业基础信息维护、备案提交与审核</div>
      </div>
      <el-button type="primary" @click="openDialog()">新增企业</el-button>
    </div>

    <el-card class="main-card">
      <el-table :data="list" border stripe style="width: 100%">
        <el-table-column prop="orgCode" label="组织机构代码" width="150" />
        <el-table-column prop="enterpriseName" label="企业名称" min-width="200" />
        <el-table-column prop="districtName" label="所属地区" width="140" />
        <el-table-column prop="contactPerson" label="联系人" width="120" />
        <el-table-column prop="phone" label="联系电话" width="140" />
        <el-table-column prop="status" label="状态" width="120" />
        <el-table-column label="操作" width="240" fixed="right">
          <template #default="{ row }">
            <el-button size="small" @click="openDialog(row)">编辑</el-button>
            <el-button size="small" type="warning" @click="submitReview(row.id)">提交备案</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <el-dialog v-model="visible" title="企业信息" width="720px">
      <el-form :model="form" label-width="120px">
        <el-form-item label="组织机构代码">
          <el-input v-model="form.orgCode" placeholder="请输入组织机构代码" />
        </el-form-item>
        <el-form-item label="企业名称">
          <el-input v-model="form.enterpriseName" placeholder="请输入企业名称" />
        </el-form-item>
        <el-form-item label="所属地区">
          <el-input v-model="form.districtName" placeholder="如：昆明市" />
        </el-form-item>
        <el-form-item label="联系人">
          <el-input v-model="form.contactPerson" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="联系电话">
          <el-input v-model="form.phone" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="form.email" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="主要业务">
          <el-input v-model="form.businessScope" type="textarea" :rows="3" placeholder="请输入主要经营业务" />
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
import { ElMessage } from 'element-plus'
import { createEnterprise, getEnterpriseList, submitEnterpriseReview, updateEnterprise } from '../../api/enterprise'

const list = ref([])
const visible = ref(false)
const editId = ref(null)

const form = reactive({
  orgCode: '',
  enterpriseName: '',
  districtName: '',
  contactPerson: '',
  phone: '',
  email: '',
  businessScope: ''
})

const load = async () => {
  list.value = await getEnterpriseList()
}

const openDialog = (row) => {
  editId.value = row?.id || null
  Object.assign(form, row || {
    orgCode: '',
    enterpriseName: '',
    districtName: '',
    contactPerson: '',
    phone: '',
    email: '',
    businessScope: ''
  })
  visible.value = true
}

const save = async () => {
  if (editId.value) {
    await updateEnterprise(editId.value, form)
  } else {
    await createEnterprise(form)
  }
  ElMessage.success('保存成功')
  visible.value = false
  await load()
}

const submitReview = async (id) => {
  await submitEnterpriseReview(id)
  ElMessage.success('已提交备案')
  await load()
}

onMounted(load)
</script>