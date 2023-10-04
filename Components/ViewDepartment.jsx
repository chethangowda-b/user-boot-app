const ViewDepartment=()=>{
    let department=JSON.parse(localStorage.getItem("department"))
    return(
        <div>
            <h2>Name:{department.name}</h2>
            <h2>Id:{department.id}</h2>
            <h2>Location:{department.location}</h2>
            <h2>Phone:{department.phone}</h2>
            <h2>Email:{department.email}</h2>
        </div>
    )
}

export default ViewDepartment