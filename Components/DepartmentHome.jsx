import { Link, useNavigate } from "react-router-dom"

const DepartmentHome=()=>{

    let navigate=useNavigate()
    let logout=()=>{
        localStorage.removeItem("department")
        navigate("/")
    }
    return(
        <div>
            <Link to="/viewdepartment"><h2>View Profile</h2></Link>
            <Link to="/updatedpartment"><h2>Update Profile</h2></Link>
            <Link to="/deletepartment"><h2>Delete Profile</h2></Link>
            <Link to="/addemployee"><h2>Add Employee</h2></Link>
            <Link to="/viewemployees"><h2>View Employees</h2></Link>
            <button onClick={logout}>Logout</button>
        </div>
    )
}
export default DepartmentHome