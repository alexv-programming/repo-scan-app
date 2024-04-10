import { useContext, useEffect } from "react";

import { APIContext } from "../api-services/apiContext";
import { fetchScans } from "../api-services/repo-scan-ms";
import { APIContextType } from "../types";
import ScansTableSearchable from "./ScansTableSearchable";

const ScansTableContainer = ({ userId }: { userId: number }) => {
  const { isLoading, setScans, setIsLoading } = useContext(
    APIContext
  ) as APIContextType;

  useEffect(() => {
    setIsLoading(true);
    fetchScans(userId)
      .then((res) => setScans(res.data))
      .catch((err) => {
        console.error("Fetch error:", err);
      })
      .finally(() => setIsLoading(false));
  }, [setIsLoading, setScans, userId]);

  if (isLoading) {
    return <div>Loading...</div>;
  }

  return <ScansTableSearchable />;
};

export default ScansTableContainer;
