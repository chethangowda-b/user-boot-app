import axios from "axios"
import { useState } from "react"

const SignUp=()=>{

    let [name,setName]=useState("")
    let [location,setLocation]=useState("")
    let [phone,setPhone]=useState("")
    let [email,setEmail]=useState("")
    let [password,setPassword]=useState("")

    let handleSubmit=(e)=>{
        e.preventDefault()
        let department={name,location,phone,email,password}
        axios.post("http://localhost:8080/departments",department).then((response)=>{
            alert("Department Saved Succesfully with  Id:"+response.data.data.id)
            console.log(response)
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
                <button>SignUp</button>
            </form>
        </div>
    )
}

export default SignUp