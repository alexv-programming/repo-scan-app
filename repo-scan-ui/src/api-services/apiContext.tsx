import React from "react";

import { APIContextType, ScanData } from "../types";

export const APIContext = React.createContext<APIContextType | null>(null);

const ApiContextProvider: React.FC<{ children: React.ReactNode }> = ({
  children,
}) => {
  const [scans, setScans] = React.useState<ScanData[]>([]);
  const [isLoading, setIsLoading] = React.useState<boolean>(false);

  const updateScans = (scan: ScanData) => {
    setScans((prev) => [scan, ...prev]);
  };

  return (
    <APIContext.Provider
      value={{ scans, isLoading, setScans, setIsLoading, updateScans }}
    >
      {children}
    </APIContext.Provider>
  );
};

export default ApiContextProvider;
