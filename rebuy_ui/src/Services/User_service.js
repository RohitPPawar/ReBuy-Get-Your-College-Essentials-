import { myAxois } from "./Helper";

export const signUp=async (user)=>{
    const responce = await myAxois.post("/user/", user);
    return responce.data;
};

export const getAllUser=async ()=>{
    const responce = await myAxois.get("user/");
    return responce.data;
}

export const login = async (loginDetails)=>{
    const responce = await myAxois.post("/user/login", loginDetails);
    return responce.data;
}

