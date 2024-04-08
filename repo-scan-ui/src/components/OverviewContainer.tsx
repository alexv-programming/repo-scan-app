import React, { useEffect, useState } from 'react'

import { fetchOverview } from '../api-services/repo-scan-ms'
import { OverviewData } from '../types'
import Overview from './Overview'

const OverviewContainer = ({ userId }: { userId: number }) => {
  const [overviewData, setOverviewData] = useState<OverviewData[]>([])

  useEffect(() => {
    fetchOverview(userId)
      .then((res) => {
        console.log(res.status)
        if (!res.status) {
          throw new Error('Network response was not ok')
        }
        setOverviewData(res.data)
      })

      .catch((err) => {
        console.error('Fetch error:', err)
      }) //TODO: handle error
  }, [userId])

  if (overviewData.length === 0) {
    return <div>Loading...</div>
  }

  return (
    <div>
      <Overview data={overviewData} />
    </div>
  )
}

export default OverviewContainer
