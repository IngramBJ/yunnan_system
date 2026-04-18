import request from './request'

export const getSystemStats = () => request.get('/system/stats')
export const getSystemMonitor = () => request.get('/system/monitor')