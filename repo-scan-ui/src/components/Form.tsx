import React from 'react'
import { SubmitHandler, useForm } from 'react-hook-form'

interface IFormInput {
  type: 'SCA' | 'SAST' | 'RENOVATE'
  branch: string
  repo: string
}

const NewScanForm: React.FC = () => {
  const {
    register,
    handleSubmit,
    reset,
    formState: { errors },
  } = useForm<IFormInput>()

  const onSubmit: SubmitHandler<IFormInput> = (data) => {
    console.log(data)
    // Here, you would typically make an API call to submit the data
    reset() // Optional: Reset the form after submission
  }

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <div>
        <label>Type</label>
        <select
          {...register('type', { required: true })}
          placeholder="SCA SAST RENOVATE">
          <option value="SCA">SCA</option>
          <option value="SAST">SAST</option>
          <option value="RENOVATE">RENOVATE</option>
        </select>
        {errors.type && <p>Type is required.</p>}
      </div>

      <div>
        <label>Branch</label>
        <input {...register('branch', { required: true })} />
        {errors.branch && <p>Branch is required.</p>}
      </div>

      <div>
        <label>Repo</label>
        <input {...register('repo', { required: true })} />
        {errors.repo && <p>Repo is required.</p>}
      </div>

      <input type="submit" />
    </form>
  )
}

export default NewScanForm
