import { BrowserRouter, Route, Routes } from "react-router-dom"
import SignUp from "./Components/SignUp"
import SignIn from "./Components/SignIn"
import DepartmentHome from "./Components/DepartmentHome"
import Protect from "./Components/Protect"
import AddEmployee from "./Components/AddEmployee"
import ViewDepartment from "./Components/ViewDepartment"
import UpdateDepartment from "./Components/UpdateDepartment"
import DeleteDepartment from "./Components/DeleteDepartment"
import ViewEmployees from "./Components/ViewEmployees"
import EditEmployee from "./Components/EditEmployee"

const App=()=>{
    return(
        <div>
            <BrowserRouter>
            <Routes>
                <Route path="/" element={<SignIn/>}></Route>
                <Route path="/departmenthome" element={<Protect Child={DepartmentHome}/>}></Route>
                <Route path="/signup" element={<SignUp/>}></Route>
                <Route path="/viewdepartment" element={<Protect Child={ViewDepartment}/>}></Route>
                <Route path="/updatedpartment" element={<Protect Child={UpdateDepartment}/>}></Route>
                <Route path="/deletepartment" element={<Protect Child={DeleteDepartment}/>}></Route>
                <Route path="/addemployee" element={<Protect Child={AddEmployee}/>}></Route>
                <Route path="/viewemployees" element={<Protect Child={ViewEmployees}/>}></Route>
                <Route path="/editemployee" element={<Protect Child={EditEmployee}/>}></Route>


            </Routes>
            </BrowserRouter>
        </div>
    )
}
export default App