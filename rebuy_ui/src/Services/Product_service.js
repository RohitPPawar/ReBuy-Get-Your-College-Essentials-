import { myAxois } from "./Helper"

export const getAllProduct=async ()=>{
    const responce = await myAxois.get("product/")
    return responce.data
}