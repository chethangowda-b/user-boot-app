import axios from "axios"
import { useState } from "react"

const EditEmployee=()=>{
    let employee=JSON.parse(localStorage.getItem("employee"))
    let [name,setName]=useState(employee.name)
    let [desg,setDesg]=useState(employee.desg)
    let [salary,setSalary]=useState(employee.salary)
    let [age,setAge]=useState(employee.age)
    let [phone,setPhone]=useState(employee.phone)
    let [email,setEmail]=useState(employee.email)


    let add=(e)=>{
        let department=JSON.parse(localStorage.getItem("department"))
        e.preventDefault()
        let employee={name,desg,salary,age,phone,email}
        axios.put(`http://localhost:8080/employees/${department.id}`,employee).then((response)=>{
        alert("Product Updated")
        }).catch(()=>{
            alert("Some Thing Went Wrong")
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
                <button>View Employee</button>
            </form>
        </div>
    )
}

export default EditEmployee