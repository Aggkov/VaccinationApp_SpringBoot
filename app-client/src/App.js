
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import "bootstrap/dist/css/bootstrap.min.css";
import './App.css';
import ListVaccinationCenterComponent from './components/VaccinationCenter/ListVaccinationCenterComponent';
import DateInput from "./components/Inputs/DateInput";

function App() {
  return (
    <div className="App">

      <Router>
        <div className="">
          <Switch>
            <Route path="/" exact component={DateInput} />
            <Route path="/getAvailable/:dateFrom" exact><ListVaccinationCenterComponent />
            </Route>
            {/* <Route  <DateInput /> */}
          </Switch>

        </div>
      </Router >
    </div >
  );
}

export default App;
