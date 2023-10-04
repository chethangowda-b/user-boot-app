import axios from "axios"
import { useState } from "react"
import { useNavigate } from "react-router-dom"

const UpdateDepartment=()=>{

    let department=JSON.parse(localStorage.getItem("department"))
    let navigate=useNavigate()

    let [name,setName]=useState(department.name)
    let [location,setLocation]=useState(department.location)
    let [phone,setPhone]=useState(department.phone)
    let [email,setEmail]=useState(department.email)
    let [password,setPassword]=useState(department.password)
    let [id,setId]=useState(department.id)

    let handleSubmit=(e)=>{
        e.preventDefault()
        let department={id,name,location,phone,email,password}
        axios.put("http://localhost:8080/departments",department).then((response)=>{
            alert("Department Updated succesfully with id"+response.data.data.id)
            localStorage.setItem("department",JSON.stringify(response.data.data))
            console.log(response)
            navigate("/viewdepartment")
        })
    }
    return(
        <div>
             <form onSubmit={handleSubmit}>
                <input type="text" value={name} onChange={(e)=>{setName(e.target.value)}} placeholder="Enter Department Name" /><br />
                <input type="text"value={location}  onChange={(e)=>{setLocation(e.target.value)}} placeholder="Enter Department Location" /><br />
                <input type="tel" value={phone}  onChange={(e)=>{setPhone(e.target.value)}} placeholder="Enter Your Department phone Number" /><br />
                <input type="email" value={email}  onChange={(e)=>{setEmail(e.target.value)}} placeholder="Enter Your Department Email" /><br />
                <input type="password" value={password}  onChange={(e)=>{setPassword(e.target.value)}} placeholder="Enter Password" /><br />
                <button>Update</button>
            </form>
        </div>
    )
}


export default UpdateDepartment