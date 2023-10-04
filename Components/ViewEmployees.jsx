import axios from "axios"
import { useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"

const ViewEmployees=()=>{

    let [employees,setEmployees]=useState([])
    let department=JSON.parse(localStorage.getItem("department"))
    let navigate=useNavigate()

    let editEmployee=(id)=>{
        axios.get(`http://localhost:8080/employees/${id}`).then((response)=>{
        localStorage.setItem("employee",JSON.stringify(response.data.data))
        navigate("/editemployee")
        }).catch(()=>{
            alert("Somthing Went Wrong")
        })
    }


    let deleteEmployee=((id)=>{
        axios.delete(`http://localhost:8080/employees/${id}`).then((response)=>{
        alert(response.data.message)
        navigate("/viewemployees")
        }).catch(()=>{
            alert("Cannot Delete Product")
        })
    })

    useEffect(()=>{
        let fetchData=()=>{
            axios.get(`http://localhost:8080/employees/bydepartment-id/${department.id}`).then((response)=>{
                setEmployees(response.data.data)
            }).catch(()=>{
                alert("Not a Good Request")
            })
        }
        fetchData()
    },[])

    return(
        <div>
            <table border={2}>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Designation</th>
                    <th>Salary</th>
                    <th>Age</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                {
                    employees.map((p)=>{
                        return(
                            <tr>
                                <td>{p.id}</td>
                                <td>{p.name}</td>
                                <td>{p.desg}</td>
                                <td>{p.salary}</td>
                                <td>{p.age}</td>
                                <td>{p.phone}</td>
                                <td>{p.email}</td>
                                <td><button onClick={()=>{editEmployee(p.id)}}>Edit</button> </td>
                                <td><button onClick={()=>{deleteEmployee(p.id)}}>Delete</button></td>
                            </tr>
                        )
                    })
                }
            </table>
        </div>
    )
}

export default ViewEmployees