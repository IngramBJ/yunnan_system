<template>
  <div class="page-container">
    <div class="page-header">
      <div>
        <div class="page-title">图表分析</div>
        <div class="page-subtitle">岗位变动趋势、对比分析与统计展示</div>
      </div>
    </div>

    <el-row :gutter="16">
      <el-col :span="12">
        <el-card class="main-card">
          <template #header>
            <div class="card-title">岗位变动趋势</div>
          </template>
          <div ref="lineRef" style="height: 360px;"></div>
        </el-card>
      </el-col>

      <el-col :span="12">
        <el-card class="main-card">
          <template #header>
            <div class="card-title">企业类型占比</div>
          </template>
          <div ref="pieRef" style="height: 360px;"></div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script setup>
import { onMounted, ref } from 'vue'
import * as echarts from 'echarts'

const lineRef = ref()
const pieRef = ref()

onMounted(() => {
  const lineChart = echarts.init(lineRef.value)
  lineChart.setOption({
    tooltip: { trigger: 'axis' },
    xAxis: {
      type: 'category',
      data: ['2025-01', '2025-02', '2025-03', '2025-04', '2025-05', '2025-06']
    },
    yAxis: { type: 'value' },
    series: [
      {
        name: '岗位变化数量占比',
        type: 'line',
        smooth: true,
        data: [12, 18, 15, 22, 30, 28]
      }
    ]
  })

  const pieChart = echarts.init(pieRef.value)
  pieChart.setOption({
    tooltip: { trigger: 'item' },
    legend: { bottom: 0 },
    series: [
      {
        name: '企业类型',
        type: 'pie',
        radius: '65%',
        data: [
          { name: '制造业', value: 35 },
          { name: '服务业', value: 25 },
          { name: '建筑业', value: 18 },
          { name: '其他', value: 22 }
        ]
      }
    ]
  })
})
</script>