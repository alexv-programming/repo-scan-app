import { OverviewData } from "../types";

const Overview = ({ data }: { data: OverviewData[] }) => {
  return (
    <div>
      {data.map((item) => {
        return (
          <div key={item.scanType}>
            {item.scanType +
              " " +
              item.scansCount +
              " issues found: " +
              item.issues}
          </div>
        );
      })}
    </div>
  );
};

export default Overview;
