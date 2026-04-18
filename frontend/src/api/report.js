import request from './request'

export const getReportList = () => request.get('/report')
export const getReportByEnterprise = (enterpriseId) => request.get(`/report/enterprise/${enterpriseId}`)
export const submitReport = (data) => request.post('/report/submit', data)
export const approveReport = (id, remark) => request.post(`/report/${id}/approve`, null, { params: { remark } })
export const returnReport = (id, remark) => request.post(`/report/${id}/return`, null, { params: { remark } })