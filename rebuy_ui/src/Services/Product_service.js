import { myAxois } from "./Helper"

export const getAllProduct=async ()=>{
    const response = await myAxois.get("product/")
    return response.data
}


export const addProduct= (newProduct)=>{
    console.log(newProduct);
    const response = myAxois.post("/product/",newProduct);
    return response.data;
}

