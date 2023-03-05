import React from 'react'
import { ToastContainer } from 'react-toastify'
import CustomNavbar from './CustomNavbar'
import { useState } from 'react';
const Admin=()=> {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    return (
    <div>

<div className='admin'>
            <CustomNavbar/>
            <div className="container mt-5">
                <div className="row">
                    <div className="col-md-3 offset-md-10 mt-5">
                        <div className="card mt-5">
                            <div className="card-header text-center fs-3 text-success">Admin Login</div>
                                <div className="card-body">
                                <div className="mb-3">
                                    <label>Email ID </label>
                                    <input type="email" id="email" className='form-control' name='email' 
                                    value={email} onChange={(e) => setEmail(e.target.value)} placeholder="Your Email"/>
                                </div>
                                <div className="mb-3">
                                    <label>Password</label>
                                    <input type="password"  id="password" className='form-control' name='password'
                                     value={password} onChange={(e) => setPassword(e.target.value)} placeholder="Your Password"/>
                                </div>
                                <div className="text-center">
                                    <button className='btn btn-success me-2' id="signin" >Login</button><br></br>
                                    <hr></hr>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <ToastContainer position="top-center"/>
        </div>     
    </div>
  )
}

export default Admin;