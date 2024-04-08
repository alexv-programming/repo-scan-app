import axios from 'axios'

import { OVERVIEW, SCANS_BY_USER_ID_URL } from './apiConsts'

export const fetchScans = async (userId: number) => {
  return axios.get(SCANS_BY_USER_ID_URL + userId)
}

export const fetchOverview = async (userId: number) => {
  return axios.get(SCANS_BY_USER_ID_URL + userId + OVERVIEW)
}
