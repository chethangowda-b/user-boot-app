import axios from "axios"
import { useState } from "react"

const AddEmployee=()=>{

    let [name,setName]=useState("")
    let [desg,setDesg]=useState("")
    let [salary,setSalary]=useState("")
    let [age,setAge]=useState("")
    let [phone,setPhone]=useState("")
    let [email,setEmail]=useState("")

    let add=(e)=>{
        let department=JSON.parse(localStorage.getItem("department"))
        e.preventDefault()
        let employee={name,desg,salary,age,phone,email}
        axios.post(`http://localhost:8080/employees/${department.id}`,employee).then((response)=>{
            alert("Employee added with id"+ response.data.data.id)
        }).catch(()=>{
            alert("Some Thing went Wrong")
        })
    }

    return(
        <div>
            <form onSubmit={add}>
                Name :<input type="text" value={name} onChange={(e)=>{setName(e.target.value)}}/> <br />
                Designation : <input type="text" value={desg} onChange={(e)=>{setDesg(e.target.value)}} /> <br />
                Salary : <input type="number" value={salary} onChange={(e)=>{setSalary(e.target.value)}} /> <br />
                Age : <input type="number" value={age} onChange={(e)=>{setAge(e.target.value)}}/> <br />
                Phone : <input type="number" value={phone} onChange={(e)=>{setPhone(e.target.value)}} /> <br />
                Email : <input type="email" value={email} onChange={(e)=>{setEmail(e.target.value)}} /> <br />
                <button>Add Employee</button>
            </form>
        </div>
    )
}

export default AddEmployee