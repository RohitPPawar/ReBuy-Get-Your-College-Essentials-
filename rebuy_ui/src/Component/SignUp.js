import React from 'react'
import { useState } from 'react'
// import RegisterService from '../Services/RegisterService'
import customNavbar from './CustomNavbar';
import '../Pages/Home';
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import userEvent from '@testing-library/user-event';

const SignUp = () => {

    const [message, setMessage] = useState("");
    const navigate=useNavigate();
    const [register, setRegister] = useState({
        FirstName: "",
        LastName: "",
        Email: "",
        Password: "",
        Mobile: "",
        CollegeName:"",
        Address: "",


    })

    const handleChange = (e) => {
        const value = e.target.value
        setRegister({ ...register, [e.target.name]: value })
    }


    const saveRegister=(e)=>{
                        if(userEvent.address.length===0){}

    }

    const handleReset=()=>{
        setRegister({
            FirstName: "",
            LastName: "",
            Email: "",
            Password: "",
            Mobile: "",
            CollegeName:"",
            Address: "",
    
        })
    }

    const registerUser = (e) => {
        if(register.FirstName.length===0){toast.error("Please enter Firstname")}
        else if(register.LastName.length===0){ toast.error("Please enter lastName")}
        else if(register.Email.length===0){toast.error("Please enter email")}
        else if(register.Password.length===0){toast.error("Please enter password")}
        else if(register.Mobile.length===0){toast.error("Please enter mobile")}
        else if(register.CollegeName.length===0){toast.error("Please enter Clg name")}
    //     else{
    //     RegisterService.addUser(register)
    //         .then(response => {
    //              setMessage("Register Successfull.")
    //             //  localStorage.setItem("id",response.data.id)
    //             sessionStorage.setItem("id",response.data.value)
    //              navigate("/Service")
    //             })
    //         .catch(error => { console.log(error) })
    // }
    
}
    return (
        <div className='base'>
            <customNavbar/>
            <div className="container mt-3">
                <div className="row">
                    <div className="col-md-4  offset-md-4 mt-5">
                        <div className="card mt-5">
                            <div className="card-header text-center fs-3 text-success">Sign Up
                                {
                                    message && <p className='text-success'>{message}</p>
                                }
                            </div>
                            <div className="card-body">
                                {/* <div className="mb-2 ">
                                    <label>FirstName</label>
                                    <input type="text" className='form-control' name='firstname'
                                        value={register.FirstName} onChange={(e) => handleChange(e)} />
                                </div> */}
                               

                            <div className='mb-2'> <lable>FirstName</lable>
                            <input type ='text' className='form-control  name =firstname' ></input>
                            </div>
                               

                                <div className="mb-2">
                                    <label>LastName</label>
                                    <input type="text" className='form-control' name='lastname'
                                        value={register.surname} onChange={(e) => handleChange(e)} />
                                </div>
                                <div className="mb-2">
                                    <label>Email</label>
                                    <input type="email" className='form-control' name='email'
                                        value={register.email} onChange={(e) => handleChange(e)} />
                                </div>
                                <div className="mb-2">
                                    <label>Password</label>
                                    <input type="password" className='form-control' name='password'
                                        value={register.password} onChange={(e) => handleChange(e)} />
                                </div>
                                <div className="mb-3">
                                    <label>Confirm Password</label>
                                    <input type="password" className='form-control' name='cpassword' />
                                </div>
                               
                                <div className="mb-2" h>
                                    <label>CollegeName</label>
                                    <input type="text" className='form-control' name='ClgName'
                                        />
                                </div>
                                {/* value={register.CollegeName} onChange={(e) => handleChange(e)} */}

                                
                                <div className="text-center">
                                    <button className='btn btn-success me-2' onClick={registerUser}>RegisterUser</button>
                                    <button type='reset' className="btn btn-danger me-2" onClick={handleReset} >Reset</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <ToastContainer position="top-center"/>
        </div>

    )
}

export default SignUp