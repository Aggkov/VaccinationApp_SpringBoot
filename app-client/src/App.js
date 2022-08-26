
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import "bootstrap/dist/css/bootstrap.min.css";
import './App.css';
import ListVaccinationCenterComponent from './components/VaccinationCenter/ListVaccinationCenterComponent';
import DateInput from "./components/Inputs/DateInput";
import Home from './components/Home';
import Login from './components/Login';
import Profile from './components/Profile';

function App() {
  return (
    <div className="App">
      <Router>
        <div>
          <Switch>
            <Route path="/login" component={Login} />
            <Route path="/home" component={Home} />
            <Route path="/profile" component={Profile} />
            <Route path="/date" component={DateInput} />
            <Route path="/getAvailable/:dateFrom" component={ListVaccinationCenterComponent} />
          </Switch>
        </div>
      </Router >
    </div >
  );
}

export default App;
