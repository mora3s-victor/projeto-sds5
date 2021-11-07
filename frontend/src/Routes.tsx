import Dashboard from 'pages/Dashboard';
import Home from 'pages/Home';
import { BrowserRouter,Route, Switch } from 'react-router-dom';

//essa função é uma variável, uma expressão lambda
const Routes= () => {
    return (
      <BrowserRouter>
        <Switch>
            <Route path= "/" exact>
              <Home/>
            </Route>
            <Route path= "/dashboard">
              <Dashboard/>
            </Route>
        </Switch>
      </BrowserRouter>
    );
}

export default Routes;
