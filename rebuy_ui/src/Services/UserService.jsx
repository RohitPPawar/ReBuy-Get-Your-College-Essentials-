import axios from "axios";

const url='http://localhost:3000';

class UserService{

    addUser(user){
        return axios.post(url+'/api/v2/addUser',user) 
    }

     loginUser(data){
        return axios.post(url+'/api/v2/login',data)
     }

     getUserByEmail(email){
        return axios.get(url+'/api/v2/findByEmail/'+email)
     }

     updateUser(d){
        return axios.put(url+'/api/v2/updateUserProfile/{userid}',d)
     }
  }

export default new UserService();




