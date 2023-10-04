import axios from "axios"
import { useState } from "react"
import { Link, useNavigate } from "react-router-dom"

const SignIn=()=>{

    let [email,setEmail]=useState("")
    let [password,setPassword]=useState("")

    let navigate=useNavigate()

    let onClick=(e)=>{
        e.preventDefault()
        axios.post(`http://localhost:8080/departments/verifyByEmail?email=${email}&password=${password}`).then((response)=>{
            localStorage.setItem("department",JSON.stringify(response.data.data))   
            console.log(response.data.message)
            alert(response.data.message)
            navigate("/departmenthome")
        })
        .catch=()=>{
            alert("Invalid Email Id and Password")
            navigate("/")
        }
    }
    return(
        <div>
            <form>
            <input type="email" value={email} onChange={(e)=>{setEmail(e.target.value)}} placeholder="Enter Department Email" /><br />
            <input type="password" value={password} onChange={(e)=>{setPassword(e.target.value)}} placeholder="Enter Password" /><br />
            <button onClick={onClick}>SignIn</button>
            </form>
            <Link to="/signup"><button>SignUp</button></Link>
        </div>
    )
}

export default SignIn