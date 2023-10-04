import SignIn from "./SignIn";

const Protect=({Child})=>{

    let verify=()=>{
        let department=localStorage.getItem("department")
        if(department==null){
        return false;
        }
        else{
            return true;
        }
    }
    return(
        <>
        {
            verify() ? <Child/> : <SignIn/>}
        </>
    )
}

export default Protect