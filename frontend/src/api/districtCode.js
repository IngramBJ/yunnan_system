import request from './request'

export const getDistrictCodeList = () => request.get('/district-code')
export const createDistrictCode = (data) => request.post('/district-code', data)
export const updateDistrictCode = (id, data) => request.put(`/district-code/${id}`, data)
export const deleteDistrictCode = (id) => request.delete(`/district-code/${id}`)