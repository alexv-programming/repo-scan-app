import React, { useEffect, useState } from 'react'

import { fetchOverview } from '../api-services/repo-scan-ms'
import { OverviewData } from '../types'
import Overview from './Overview'

const OverviewContainer = ({ userId }: { userId: number }) => {
  const [overviewData, setOverviewData] = useState<OverviewData[]>([])

  useEffect(() => {
    fetchOverview(userId)
      .then((res) => setOverviewData(res.data))
      .catch((err) => console.log(err))
  }, [userId])

  return (
    <div>
      <Overview data={overviewData} />
    </div>
  )
}

export default OverviewContainer
