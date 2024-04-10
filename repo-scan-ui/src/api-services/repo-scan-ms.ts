import axios from "axios";

import { NewScanData, OverviewData, ScanData } from "../types";
import { OVERVIEW, SCANS_BY_USER_ID_URL, SCANS_URL } from "./apiConsts";

export const fetchScans = async (
  userId: number
): Promise<{ data: ScanData[] }> => {
  return axios.get(SCANS_BY_USER_ID_URL + userId);
};

export const fetchOverview = async (
  userId: number
): Promise<{ data: OverviewData[]; status: number }> => {
  return axios.get(SCANS_BY_USER_ID_URL + userId + OVERVIEW);
};

export const fetchNewScan = async (
  data: NewScanData
): Promise<{ data: ScanData }> => {
  return axios.post(SCANS_URL, data);
};
