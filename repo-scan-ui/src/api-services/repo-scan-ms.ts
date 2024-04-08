import axios from 'axios'

import { NewScanData } from '../types'
import { OVERVIEW, SCANS_BY_USER_ID_URL, SCANS_URL } from './apiConsts'

export const fetchScans = async (userId: number) => {
  return axios.get(SCANS_BY_USER_ID_URL + userId)
}

export const fetchOverview = async (userId: number) => {
  return axios.get(SCANS_BY_USER_ID_URL + userId + OVERVIEW)
}

export const fetchNewScan = async (data: NewScanData) => {
  return axios.post(SCANS_URL, data)
}
