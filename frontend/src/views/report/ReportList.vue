<template>
  <div class="page-container">
    <div class="page-header">
      <div>
        <div class="page-title">数据填报管理</div>
        <div class="page-subtitle">企业就业失业数据上报、审核与退回</div>
      </div>
      <el-button type="primary" @click="visible = true">新增填报</el-button>
    </div>

    <el-card class="main-card">
      <el-table :data="list" border stripe style="width: 100%">
        <el-table-column prop="enterpriseId" label="企业ID" width="100" />
        <el-table-column prop="surveyPeriodId" label="调查期ID" width="100" />
        <el-table-column prop="baseEmploymentCount" label="建档期人数" width="120" />
        <el-table-column prop="currentEmploymentCount" label="调查期人数" width="120" />
        <el-table-column prop="otherReasonCount" label="其他原因" width="100" />
        <el-table-column prop="status" label="状态" width="160" />
      </el-table>
    </el-card>

    <el-dialog v-model="visible" title="新增填报" width="760px">
      <el-form :model="form" label-width="140px">
        <el-form-item label="企业ID">
          <el-input v-model="form.enterpriseId" />
        </el-form-item>
        <el-form-item label="调查期ID">
          <el-input v-model="form.surveyPeriodId" />
        </el-form-item>
        <el-form-item label="建档期就业人数">
          <el-input v-model="form.baseEmploymentCount" />
        </el-form-item>
        <el-form-item label="调查期就业人数">
          <el-input v-model="form.currentEmploymentCount" />
        </el-form-item>
        <el-form-item label="其他原因">
          <el-input v-model="form.otherReasonCount" />
        </el-form-item>
        <el-form-item label="减少类型">
          <el-input v-model="form.decreaseType" placeholder="如：关闭破产、自然减员等" />
        </el-form-item>
        <el-form-item label="主要原因">
          <el-input v-model="form.mainReason" placeholder="如：订单不足、自然减员等" />
        </el-form-item>
        <el-form-item label="主要原因说明">
          <el-input v-model="form.mainReasonDesc" type="textarea" :rows="3" />
        </el-form-item>
      </el-form>

      <template #footer>
        <el-button @click="visible = false">取消</el-button>
        <el-button type="primary" @click="submit">提交</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { onMounted, reactive, ref } from 'vue'
import { ElMessage } from 'element-plus'
import { getReportList, submitReport } from '../../api/report'

const list = ref([])
const visible = ref(false)

const form = reactive({
  enterpriseId: '',
  surveyPeriodId: '',
  baseEmploymentCount: '',
  currentEmploymentCount: '',
  otherReasonCount: 0,
  decreaseType: '',
  mainReason: '',
  mainReasonDesc: ''
})

const load = async () => {
  list.value = await getReportList()
}

const submit = async () => {
  await submitReport(form)
  ElMessage.success('提交成功')
  visible.value = false
  await load()
}

onMounted(load)
</script>