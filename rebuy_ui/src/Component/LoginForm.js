import React from 'react'
import a from '../Images/a.png'
import email from '../Images/email.jpg'
import pass from '../Images/pass.png'
// import ./Login.css

export default function LoginForm() {
    return (
        <div>
            {/* <form>
            <table>
          <tr> <div className='mb-5'><h1>Login</h1></div>
             <div className="mb-3 col- ">
               <td><label for="" className="form-label">EmailID   :</label></td>
               <td><input type="email" class="form-control" id="email" placeholder="email Id"/></td>
           </div>
          </tr>
           <tr>
             <div className="mb-5 col-">
             <td><label for="" class="form-label">Password :</label></td>
             <td><input type="password" class="form-control" name="" id="loginpwd" placeholder="password"/></td>
           </div>
           </tr>

             </table>
              </form>  */}


<div className='ul'>
            {/* <Navbar/> */}
            <div className="container mt-5">
                <div className="row">
                    <div className="col-md-3 offset-md-10 mt-5">
                        <div className="card mt-5">
                            <div className="card-header text-center fs-3 text-success">Login</div>
                                <div className="card-body">
                                <div className="mb-3">
                                    <label>Email </label>
                                    <input type="email" id="email" className='form-control' name='email' 
                                    placeholder="Your Email"/>
                                 {/* value={email} onChange={(e) => setEmail(e.target.value)} */}
                                {/* </div> */}
                                <div className="mb-3">
                                    <label>Password</label>
                                    <input type="password"  id="password" className='form-control' name='password'
                                    placeholder="Your Password"/>
                                 {/* value={password} onChange={(e) => setPassword(e.target.value)} */}
                                </div>
                                <div className="text-center">
                                    <button className='btn btn-success me-2' id="signin" >Login</button><br></br>
                                    <hr></hr>
                                    {/* onClick={onLogin} */}
                                    {/* <Link className='btn btn-warning me-2' to={'/SignUp'} >Create New Account</Link> */}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            {/* <ToastContainer position="top-center"/> */}
        </div>
        
           
</div>
     </div>



    )
}

 