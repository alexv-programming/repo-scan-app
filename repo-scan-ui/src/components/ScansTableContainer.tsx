import React, { useEffect, useState } from 'react'

import { fetchScans } from '../api-services/repo-scan-ms'
import { ScanData } from '../types'
import ScansTableSearchable from './ScansTableSearchable'

const ScansTableContainer = ({ userId }: { userId: number }) => {
  const [scans, setScans] = useState<ScanData[]>([])

  useEffect(() => {
    fetchScans(userId).then((res) => setScans(res.data))
  }, [userId])

  return <ScansTableSearchable data={scans} />
}

export default ScansTableContainer
