import "./App.css";

import ApiContextProvider from "./api-services/apiContext";
import NewScanForm from "./components/Form";
import OverviewContainer from "./components/OverviewContainer";
import ScansTableContainer from "./components/ScansTableContainer";

function App() {
  return (
    <div className="App" data-testid="app-page">
      <h1 className="Tytle">Overview</h1>
      <OverviewContainer userId={1} />
      <ApiContextProvider>
        <h1 className="Tytle">New Scan Submission</h1>
        <NewScanForm />
        <h1 className="Tytle">Scans Table</h1>
        <ScansTableContainer userId={1} />
      </ApiContextProvider>
    </div>
  );
}

export default App;
