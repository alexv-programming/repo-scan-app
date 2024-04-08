import React from 'react'

import { ScanData } from '../types'

interface ScanTableProps {
  data: ScanData[]
}

const ScansTable: React.FC<ScanTableProps> = ({ data }) => {
  return (
    <table>
      <thead>
        <tr>
          <th>Workspace</th>
          <th>Repository</th>
          <th>Branch</th>
          <th>Scan ID</th>
          <th>Type</th>
          <th>Status</th>
          <th>Issues</th>
          <th>Valid</th>
        </tr>
      </thead>
      <tbody>
        {data.map((scan) => (
          <tr key={scan.scanId}>
            <td>{scan.workspaceName}</td>
            <td>{scan.repoName}</td>
            <td>{scan.branchName}</td>
            <td>{scan.scanId}</td>
            <td>{scan.scanType}</td>
            <td>{scan.scanStatus}</td>
            <td>{scan.scanIssues}</td>
            <td>{scan.scanValid ? 'Yes' : 'No'}</td>
          </tr>
        ))}
      </tbody>
    </table>
  )
}

export default ScansTable
