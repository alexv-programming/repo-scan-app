import axios from 'axios'

import { NewScanData, ScanData } from '../types'
import { OVERVIEW, SCANS_BY_USER_ID_URL, SCANS_URL } from './apiConsts'

export const fetchScans = async (userId: number): Promise<ScanData[]> => {
  return axios.get(SCANS_BY_USER_ID_URL + userId)
}

export const fetchOverview = async (userId: number) => {
  return axios.get(SCANS_BY_USER_ID_URL + userId + OVERVIEW)
}

export const fetchNewScan = async (data: NewScanData): Promise<ScanData> => {
  return axios.post(SCANS_URL, data)
}
