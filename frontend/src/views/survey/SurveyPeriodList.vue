<template>
  <div class="page-container">
    <div class="page-header">
      <div>
        <div class="page-title">调查期管理</div>
        <div class="page-subtitle">新增与维护调查期、上报时限</div>
      </div>
      <el-button type="primary" @click="visible = true">新增调查期</el-button>
    </div>

    <el-card class="main-card">
      <el-table :data="list" border stripe style="width: 100%">
        <el-table-column prop="periodCode" label="调查期编码" width="180" />
        <el-table-column prop="startDate" label="开始日期" width="180" />
        <el-table-column prop="endDate" label="结束日期" width="180" />
        <el-table-column prop="active" label="启用" width="100" />
      </el-table>
    </el-card>

    <el-dialog v-model="visible" title="新增调查期" width="600px">
      <el-form :model="form" label-width="120px">
        <el-form-item label="调查期编码">
          <el-input v-model="form.periodCode" placeholder="如：2026-01" />
        </el-form-item>
        <el-form-item label="开始日期">
          <el-input v-model="form.startDate" placeholder="2026-01-01" />
        </el-form-item>
        <el-form-item label="结束日期">
          <el-input v-model="form.endDate" placeholder="2026-01-31" />
        </el-form-item>
        <el-form-item label="启用">
          <el-switch v-model="form.active" />
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
import { createSurveyPeriod, getSurveyPeriodList } from '../../api/surveyPeriod'

const list = ref([])
const visible = ref(false)

const form = reactive({
  periodCode: '',
  startDate: '',
  endDate: '',
  active: true
})

const load = async () => {
  list.value = await getSurveyPeriodList()
}

const save = async () => {
  await createSurveyPeriod(form)
  ElMessage.success('保存成功')
  visible.value = false
  await load()
}

onMounted(load)
</script>