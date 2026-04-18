<template>
  <div class="page-container">
    <div class="page-header">
      <div>
        <div class="page-title">系统监控</div>
        <div class="page-subtitle">查看系统运行状态</div>
      </div>
    </div>

    <el-row :gutter="16">
      <el-col :span="8">
        <el-card class="main-card">
          <div class="card-title">CPU 使用率</div>
          <el-progress :percentage="cpu" />
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card class="main-card">
          <div class="card-title">内存使用率</div>
          <el-progress :percentage="memory" status="success" />
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card class="main-card">
          <div class="card-title">磁盘使用率</div>
          <el-progress :percentage="disk" status="warning" />
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const cpu = ref(36)
const memory = ref(62)
const disk = ref(48)
</script>