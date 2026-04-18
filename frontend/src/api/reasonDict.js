import request from './request'

export const getReasonDictList = () => request.get('/reason-dict')
export const createReasonDict = (data) => request.post('/reason-dict', data)
export const updateReasonDict = (id, data) => request.put(`/reason-dict/${id}`, data)
export const deleteReasonDict = (id) => request.delete(`/reason-dict/${id}`)