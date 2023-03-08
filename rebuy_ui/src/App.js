
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter,Route,Routes} from 'react-router-dom';
import Home from './Pages/Home';
import Login from './Pages/Login';
import SignUp from './Component/SignUp';
import AboutUs from './Pages/AboutUs';
import CustomNavbar from './Component/CustomNavbar';
import LoginForm from './Component/LoginForm';   
import Admin from './Component/Admin';
import Products from './Pages/Products';

function App() {
 const loginHandler=()=>{} //*****Consfsue***** */
  return (
  
    <div className="App  ">
          <CustomNavbar />
          {/* Login={this.loginHandler} */}
   <BrowserRouter>    

        <Routes>
        
            <Route path='/' element={<Home/>}/>
            {/* <Route path='/Login' element={<Login/>}/> */}
            <Route path='/Login' element={<LoginForm/>}></Route>
            <Route path='/SignUp' element={<SignUp/>}/>
            <Route path='/AboutUs' element={<AboutUs/>}/>
            <Route path='/Admin' element={<Admin/>}/>
            <Route path="/Product" element={<Products/>}/>
            {/* <Route path='/Admin' element={ <Admin/>}></Route> */}
        </Routes>
   </BrowserRouter>
    </div>
  ); 
}

export default App;
