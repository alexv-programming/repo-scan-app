export interface ScanData {
  id: number
  workspaceId: number
  workspaceName: string
  repoId: number
  repoName: string
  branchId: number
  branchName: string
  scanType: 'SCA' | 'SAST' | 'RENOVATE'
  scanStatus: 'PENDING' | 'COMPLETED'
  scanIssues: number
  scanValid: boolean
  submissionTime: Date
}

export interface OverviewData {
  scanType: string
  scansCount: number
  issues: number
}

export interface NewScanData {
  userId: number
  branchId: number
  scanType: 'SCA' | 'SAST' | 'RENOVATE'
}

export interface APIContextType {
  scans: ScanData[]
  isLoading: boolean
  setScans: (scans: ScanData[]) => void
  setIsLoading: (isLoading: boolean) => void
  updateScans: (scans: ScanData) => void
}
