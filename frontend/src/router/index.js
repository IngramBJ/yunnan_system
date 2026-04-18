import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/login/Login.vue'
import MainLayout from '../layouts/MainLayout.vue'
import Home from '../views/home/Home.vue'
import EnterpriseList from '../views/enterprise/EnterpriseList.vue'
import ReportList from '../views/report/ReportList.vue'
import NoticeList from '../views/notice/NoticeList.vue'
import SurveyPeriodList from '../views/survey/SurveyPeriodList.vue'
import UserList from '../views/user/UserList.vue'
import RoleList from '../views/role/RoleList.vue'
import DistrictCodeList from '../views/dictionary/DistrictCodeList.vue'
import ReasonDictList from '../views/dictionary/ReasonDictList.vue'
import Analysis from '../views/chart/Analysis.vue'
import SystemMonitor from '../views/system/SystemMonitor.vue'

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
      { path: 'survey-period', component: SurveyPeriodList },
      { path: 'user', component: UserList },
      { path: 'role', component: RoleList },
      { path: 'district-code', component: DistrictCodeList },
      { path: 'reason-dict', component: ReasonDictList },
      { path: 'analysis', component: Analysis },
      { path: 'system-monitor', component: SystemMonitor }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('token')
  if (to.path !== '/login' && !token) next('/login')
  else next()
})

export default router