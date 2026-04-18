import request from './request'

export const getEnterpriseList = () => request.get('/enterprise')
export const createEnterprise = (data) => request.post('/enterprise', data)
export const updateEnterprise = (id, data) => request.put(`/enterprise/${id}`, data)
export const submitEnterpriseReview = (id) => request.post(`/enterprise/${id}/submit-review`)
export const getEnterpriseById = (id) => request.get(`/enterprise/${id}`)