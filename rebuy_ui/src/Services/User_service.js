import { myAxois } from "./Helper";

export const signUp=(user)=>{
    return myAxois.post("/user/",user).then((responce)=>responce.data);
};

export const getAllUser=()=>{
    return myAxois.get("user/").then((responce)=>responce.data)
}
