import axios from "axios"
import { useState } from "react"
import { useNavigate } from "react-router-dom"

const DeleteDepartment=()=>{
    let navigate=useNavigate()
    let [password,setPassword]=useState("")
let onClick=()=>{
    let department=JSON.parse(localStorage.getItem("department"))
  if(password===department.password){
    axios.delete(`http://localhost:8080/departments/${department.id}`).then(()=>{
    localStorage.removeItem("department")  
    alert("user deleted succesfully")
        navigate("/")
    }).catch(()=>{
        alert("Something went wrong")
    })
  }else{
    alert("Invalid password")
    navigate("/departmenthome")
  }
}
    return(
        <div>
            <form>
            <input type="password" value={password}  onChange={(e)=>{setPassword(e.target.value)}} placeholder="Enter Password" /><br />
            <button onClick={onClick}>Delete</button>
            </form>
        </div>
    )
}

export default DeleteDepartment