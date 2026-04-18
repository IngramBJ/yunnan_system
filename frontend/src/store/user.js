import { defineStore } from 'pinia'

export const useUserStore = defineStore('user', {
  state: () => ({
    token: localStorage.getItem('token') || '',
    username: localStorage.getItem('username') || '',
    userType: localStorage.getItem('userType') || ''
  }),
  actions: {
    setUser(data) {
      this.token = data.token
      this.username = data.username
      this.userType = data.userType
      localStorage.setItem('token', data.token)
      localStorage.setItem('username', data.username)
      localStorage.setItem('userType', data.userType)
    },
    logout() {
      this.token = ''
      this.username = ''
      this.userType = ''
      localStorage.clear()
    }
  }
})