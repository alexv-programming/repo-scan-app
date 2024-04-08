export interface ScanData {
  id: number
  workspaceId: number
  workspaceName: string
  repoId: number
  repoName: string
  branchId: number
  branchName: string
  scanType: 'SCA' | 'SAST' | 'RENOVATE'
  scanStatus: string
  scanIssues: number
  scanValid: boolean
}

export interface OverviewData {
  scanType: string
  scansCount: number
  issues: number
}
