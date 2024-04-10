import React, { useContext } from "react";
import { SubmitHandler, useForm } from "react-hook-form";

import "./Form.css";
import { APIContext } from "../api-services/apiContext";
import { fetchNewScan } from "../api-services/repo-scan-ms";
import { APIContextType, NewScanData } from "../types";

const NewScanForm: React.FC = () => {
  const { updateScans } = useContext(APIContext) as APIContextType;
  const {
    register,
    handleSubmit,
    reset,
    formState: { errors },
  } = useForm<NewScanData>();

  const onSubmit: SubmitHandler<NewScanData> = (data) => {
    fetchNewScan(data)
      .then((res) => {
        updateScans(res.data);
        reset();
      })
      .catch((err) => {
        console.log(err);
        alert(`Error: ${err.message}`);
      });

    reset();
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <div>
        <label>User</label>
        <select {...register("userId", { required: true })}>
          <option value={1}>User 1</option>
          <option value={2}>User 2</option>
        </select>
        {errors.userId && <p className="validationError">user is required.</p>}
      </div>

      <div>
        <label>Type</label>
        <select {...register("scanType", { required: true })}>
          <option value="SCA">SCA</option>
          <option value="SAST">SAST</option>
          <option value="RENOVATE">RENOVATE</option>
        </select>
        {errors.scanType && (
          <p className="validationError">Type is required.</p>
        )}
      </div>

      <div>
        <label>Branch ID</label>
        <input {...register("branchId", { required: true })} />
        {errors.branchId && (
          <p className="validationError">Branch is required.</p>
        )}
      </div>

      <input type="submit" />
    </form>
  );
};

export default NewScanForm;
