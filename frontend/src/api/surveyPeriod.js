import request from './request'

export const getSurveyPeriodList = () => request.get('/survey-period')
export const createSurveyPeriod = (data) => request.post('/survey-period', data)
export const updateSurveyPeriod = (id, data) => request.put(`/survey-period/${id}`, data)