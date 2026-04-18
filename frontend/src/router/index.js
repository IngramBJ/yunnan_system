import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/login/Login.vue'
import MainLayout from '../layouts/MainLayout.vue'
import Home from '../views/home/Home.vue'
import EnterpriseList from '../views/enterprise/EnterpriseList.vue'
import ReportList from '../views/report/ReportList.vue'
import NoticeList from '../views/notice/NoticeList.vue'
import SurveyPeriodList from '../views/survey/SurveyPeriodList.vue'

const routes = [
  { path: '/login', component: Login },
  {
    path: '/',
    component: MainLayout,
    redirect: '/home',
    children: [
      { path: 'home', component: Home },
      { path: 'enterprise', component: EnterpriseList },
      { path: 'report', component: ReportList },
      { path: 'notice', component: NoticeList },
      { path: 'survey-period', component: SurveyPeriodList }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('token')
  if (to.path !== '/login' && !token) {
    next('/login')
  } else {
    next()
  }
})

export default router