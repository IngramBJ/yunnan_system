<template>
  <div class="page-container">
    <el-row :gutter="16">
      <el-col :span="8">
        <el-card class="main-card stat-card">
          <div class="stat-label">企业备案</div>
          <div class="stat-value">12</div>
          <div class="stat-tip">待审核备案企业</div>
        </el-card>
      </el-col>

      <el-col :span="8">
        <el-card class="main-card stat-card">
          <div class="stat-label">报表上报</div>
          <div class="stat-value">86</div>
          <div class="stat-tip">本期已上报企业</div>
        </el-card>
      </el-col>

      <el-col :span="8">
        <el-card class="main-card stat-card">
          <div class="stat-label">通知公告</div>
          <div class="stat-value">5</div>
          <div class="stat-tip">当前有效通知</div>
        </el-card>
      </el-col>
    </el-row>

    <el-card class="main-card" style="margin-top: 16px;">
      <template #header>
        <div class="card-title">系统说明</div>
      </template>

      <el-descriptions :column="2" border>
        <el-descriptions-item label="系统类型">企业就业失业数据采集</el-descriptions-item>
        <el-descriptions-item label="当前版本">v1.0.0</el-descriptions-item>
        <el-descriptions-item label="主要用户">省、市、企业</el-descriptions-item>
        <el-descriptions-item label="功能范围">备案、填报、审核、汇总、通知、分析</el-descriptions-item>
      </el-descriptions>
    </el-card>
  </div>
</template>

<style scoped>
.stat-card {
  min-height: 150px;
}

.stat-label {
  color: #6b7280;
  font-size: 14px;
}

.stat-value {
  margin-top: 10px;
  font-size: 36px;
  font-weight: 800;
  color: #1d4ed8;
}

.stat-tip {
  margin-top: 8px;
  color: #9ca3af;
  font-size: 12px;
}
</style>