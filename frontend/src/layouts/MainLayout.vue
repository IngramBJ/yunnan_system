<template>
  <el-container class="layout">
    <el-aside width="240px" class="aside">
      <div class="logo">
        <div class="logo-main">云南采集系统</div>
        <div class="logo-sub">Employment & Unemployment</div>
      </div>

      <el-menu
        :default-active="$route.path"
        class="menu"
        router
        background-color="#0f172a"
        text-color="#cbd5e1"
        active-text-color="#ffffff"
      >
        <el-menu-item index="/home">首页概览</el-menu-item>
        <el-menu-item index="/enterprise">企业备案</el-menu-item>
        <el-menu-item index="/report">数据填报</el-menu-item>
        <el-menu-item index="/notice">通知公告</el-menu-item>
        <el-menu-item index="/survey-period">调查期管理</el-menu-item>
      </el-menu>
    </el-aside>

    <el-container>
      <el-header class="header">
        <div>
          <div class="title">云南省企业就业失业数据采集系统</div>
          <div class="subtitle">省、市、企业三级协同管理平台</div>
        </div>

        <div class="right">
          <el-tag type="info">{{ userStore.userType || 'USER' }}</el-tag>
          <span class="username">{{ userStore.username }}</span>
          <el-button size="small" @click="logout">退出登录</el-button>
        </div>
      </el-header>

      <el-main>
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup>
import { useRouter } from 'vue-router'
import { useUserStore } from '../store/user'

const router = useRouter()
const userStore = useUserStore()

const logout = () => {
  userStore.logout()
  router.push('/login')
}
</script>

<style scoped>
.layout {
  height: 100vh;
}

.aside {
  background: #0f172a;
  border-right: 1px solid rgba(255,255,255,0.08);
}

.logo {
  padding: 20px;
  color: #fff;
  border-bottom: 1px solid rgba(255,255,255,0.08);
}

.logo-main {
  font-size: 18px;
  font-weight: 700;
}

.logo-sub {
  font-size: 12px;
  margin-top: 4px;
  color: #94a3b8;
}

.menu {
  border-right: none;
}

.header {
  background: #fff;
  border-bottom: 1px solid #e5e7eb;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 20px;
}

.title {
  font-size: 18px;
  font-weight: 700;
  color: #111827;
}

.subtitle {
  font-size: 12px;
  color: #6b7280;
  margin-top: 2px;
}

.right {
  display: flex;
  align-items: center;
  gap: 12px;
}

.username {
  color: #374151;
}
</style>