import styled from '@emotion/styled'
import React from 'react'
import { SubmitHandler, useForm } from 'react-hook-form'

import { fetchNewScan } from '../api-services/repo-scan-ms'
import { NewScanData } from '../types'

const StyledP = styled('p')({
  color: 'red',
})

const NewScanForm: React.FC = () => {
  const {
    register,
    handleSubmit,
    reset,
    formState: { errors },
  } = useForm<NewScanData>()

  const onSubmit: SubmitHandler<NewScanData> = (data) => {
    fetchNewScan(data)
      .then((res) => {
        console.log(res.status)
        if (!res.status) {
          throw new Error('Network response was not ok')
        }
      })
      .catch((err) => {
        console.log(err)
        alert(`Error: ${err.message}`)
      })

    reset()
  }

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <div>
        <label>User</label>
        <select {...register('userId', { required: true })}>
          <option value={1}>User 1</option>
          <option value={2}>User 2</option>
        </select>
        {errors.userId && <StyledP>user is required.</StyledP>}
      </div>

      <div>
        <label>Type</label>
        <select
          {...register('scanType', { required: true })}
          placeholder="SCA SAST RENOVATE">
          <option value="SCA">SCA</option>
          <option value="SAST">SAST</option>
          <option value="RENOVATE">RENOVATE</option>
        </select>
        {errors.scanType && <StyledP>Type is required.</StyledP>}
      </div>

      <div>
        <label>Branch ID</label>
        <input {...register('branchId', { required: true })} />
        {errors.branchId && <StyledP>Branch is required.</StyledP>}
      </div>

      <input type="submit" />
    </form>
  )
}

export default NewScanForm
