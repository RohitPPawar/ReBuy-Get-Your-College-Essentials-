import React from 'react'
import { useParams } from 'react-router-dom'
import { useState } from 'react'
import { Link } from 'react-router-dom'
import CustomNavbar from './CustomNavbar'
// import ./Login.css
import { ToastContainer } from 'react-toastify'
const LoginForm=()=> {
    const { Userid } = useParams();

    console.log(Userid);
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    // const onLogin=()=>{
        // let id = document.getElementById("email")
    //     let pass = document.getElementById("password")
    
    return (
        
        <div>
           
<div className='ul'>
            <CustomNavbar/>
            <div className="container mt-5">
                <div className="row">
                    <div className="col-md-3 offset-md-10 mt-5">
                        <div className="card mt-5">
                            <div className="card-header text-center fs-3 text-success">Login</div>
                                <div className="card-body">
                                <div className="mb-3">
                                    <label>Email </label>
                                    <input type="email" id="email" className='form-control' name='email' 
                                    placeholder="Your Email" value={email} onChange={(e)=>setEmail(e.target.value)}/>

                                {/* </div> */}
                                <div className="mb-3">
                                    <label>Password</label>
                                    <input type="password"  id="password" className='form-control' name='password'
                                    placeholder="Your Password"   value={password} onChange={(e) => setPassword(e.target.value)}/>

                                </div>
                                <div className="text-center">
                                    <button className='btn btn-success me-2' id="signin" type='submit' >Login</button><br></br>
                                    <hr></hr>

                                    <Link className='btn btn-warning me-2' to={'/SignUp'} >Create New Account</Link>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <ToastContainer position="top-center"/>
        </div>

       </div>
     </div>



    )
    }

export default LoginForm;