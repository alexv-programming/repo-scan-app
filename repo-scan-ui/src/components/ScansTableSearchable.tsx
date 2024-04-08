import { DataGrid, GridColDef } from '@mui/x-data-grid'
import * as React from 'react'

import { ScanData } from '../types'

const columns: GridColDef[] = [
  { field: 'id', headerName: 'Scan ID', width: 90 },
  {
    field: 'scanValid',
    headerName: 'Valid',
    width: 100,
    valueGetter: (value, row) => (row.scanValid ? 'Yes' : 'No'),
  },
  { field: 'scanType', headerName: 'Scan Type', width: 130 },
  { field: 'scanStatus', headerName: 'Status', width: 120 },
  { field: 'scanIssues', headerName: 'Issues', width: 100 },
  { field: 'workspaceName', headerName: 'Workspace', width: 150 },
  { field: 'repoName', headerName: 'Repository', width: 150 },
  { field: 'branchName', headerName: 'Branch', width: 150 },
]

function DataTable({ data }: { data: ScanData[] }) {
  return (
    <div style={{ height: 'fit-content', width: '100%' }}>
      <DataGrid
        rows={data}
        columns={columns}
        initialState={{
          pagination: {
            paginationModel: { page: 0, pageSize: 5 },
          },
        }}
        pageSizeOptions={[5, 10]}
      />
    </div>
  )
}

export default DataTable
