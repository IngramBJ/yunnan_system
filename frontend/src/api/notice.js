import request from './request'

export const getNoticeList = () => request.get('/notice')
export const getNoticeById = (id) => request.get(`/notice/${id}`)
export const createNotice = (data, publisherId, publisherName) =>
  request.post('/notice', data, { params: { publisherId, publisherName } })
export const updateNotice = (id, data) => request.put(`/notice/${id}`, data)
export const deleteNotice = (id) => request.delete(`/notice/${id}`)