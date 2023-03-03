
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter,Route,Routes} from 'react-router-dom';
import { Button } from 'reactstrap';
import Home from './Pages/Home';
import Login from './Pages/Login';
import SignUp from './Pages/SignUp';
import AboutUs from './Pages/AboutUs';
import CustomNavbar from './Component/CustomNavbar';
// import LoginForm from './Components/LoginForm';
function App() {
  return (
    <div className="App page">
     <CustomNavbar/>
     {/* <LoginForm></LoginForm> */}
   <BrowserRouter>
        <Routes>
        
            <Route path='/' element={<Home/>}/>
            <Route path='/Login' element={<Login/>}/>
            <Route path='/SignUp' element={<SignUp/>}/>
            <Route path='/AboutUs' element={<AboutUs/>}/ >
        </Routes>
   </BrowserRouter>
    </div>
  ); 
}

export default App;
