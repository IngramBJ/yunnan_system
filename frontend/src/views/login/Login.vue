<template>
  <div class="login-page">
    <div class="login-left">
      <div class="hero-title">云南省企业就业失业数据采集系统</div>
      <div class="hero-subtitle">
        统一备案 · 月度填报 · 审核上报 · 汇总分析
      </div>
    </div>

    <div class="login-right">
      <el-card class="login-card main-card">
        <template #header>
          <div class="card-title">系统登录</div>
        </template>

        <el-form ref="formRef" :model="form" :rules="rules" label-position="top">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="form.username" placeholder="请输入用户名" size="large" />
          </el-form-item>

          <el-form-item label="密码" prop="password">
            <el-input v-model="form.password" type="password" placeholder="请输入密码" show-password size="large" />
          </el-form-item>

          <el-button type="primary" size="large" :loading="loading" style="width: 100%;" @click="handleLogin">
            登录系统
          </el-button>
        </el-form>
      </el-card>
    </div>
  </div>
</template>

<script setup>
import { reactive, ref } from 'vue'
import { useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'
import { loginApi } from '../../api/auth'
import { useUserStore } from '../../store/user'

const router = useRouter()
const userStore = useUserStore()
const formRef = ref()
const loading = ref(false)

const form = reactive({
  username: 'admin',
  password: 'admin123'
})

const rules = {
  username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
  password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
}

const handleLogin = async () => {
  await formRef.value.validate()
  loading.value = true
  try {
    const data = await loginApi(form)
    userStore.setUser(data)
    ElMessage.success('登录成功')
    router.push('/home')
  } finally {
    loading.value = false
  }
}
</script>

<style scoped>
.login-page {
  height: 100vh;
  display: grid;
  grid-template-columns: 1.2fr 0.8fr;
  background: linear-gradient(135deg, #0f172a 0%, #1d4ed8 55%, #38bdf8 100%);
}

.login-left {
  color: #fff;
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 80px;
}

.hero-title {
  font-size: 38px;
  font-weight: 800;
  line-height: 1.3;
  margin-bottom: 16px;
}

.hero-subtitle {
  font-size: 16px;
  color: rgba(255,255,255,0.88);
}

.login-right {
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 40px;
}

.login-card {
  width: 100%;
  max-width: 420px;
  border-radius: 18px;
}
</style>