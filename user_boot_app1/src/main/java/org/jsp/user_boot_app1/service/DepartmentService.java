package org.jsp.user_boot_app1.service;

import java.util.List;
import java.util.Optional;

import org.jsp.user_boot_app1.dao.DepartmentDao;
import org.jsp.user_boot_app1.dto.Department;
import org.jsp.user_boot_app1.dto.ResponseStructure;
import org.jsp.user_boot_app1.exception.IdNotFoundException;
import org.jsp.user_boot_app1.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentDao dao;
	
	public ResponseEntity<ResponseStructure<Department>> saveDepartment(Department dept){
		ResponseStructure<Department> structure=new ResponseStructure<>();
		structure.setData(dao.saveDepartment(dept));
		structure.setMessage("Department Saved with Id :"+dept.getId());
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Department>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Department>> updateDepartment(Department dept){
		ResponseStructure<Department> structure=new ResponseStructure<>();
		structure.setData(dao.saveDepartment(dept));
		structure.setMessage("Department Updated");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Department>>(structure,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Department>> findById(int id){
		ResponseStructure<Department> structure=new ResponseStructure<>();
		Optional<Department> recDepartment=dao.findById(id);
		if(recDepartment.isPresent()) {
			structure.setMessage("Department Found");
			structure.setData(recDepartment.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Department>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteDepartment(int id){
		ResponseStructure<String> structure=new ResponseStructure<>();
		Optional<Department> recDepartment=dao.findById(id);
		if(recDepartment.isPresent()) {
			structure.setMessage("Department Deleted");
			structure.setData("Department Found");
			structure.setStatusCode(HttpStatus.OK.value());
			dao.deleteDepartment(id);
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
		}
		structure.setMessage("Departmen Not deleted");
		structure.setData("Department not found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new 	ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<List<Department>>> findAll(){
	ResponseStructure<List<Department>> structure=new ResponseStructure<>();
		structure.setData(dao.findAll());
		structure.setMessage("Department Found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Department>>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Department>> verifyDepartment(String email,String password){
		ResponseStructure<Department> structure=new ResponseStructure<>();
		Optional<Department> recDepartment=dao.verifyDepartment(email, password);
		if(recDepartment.isPresent()) {
			structure.setMessage("Department Verified Succesfully");
			structure.setData(recDepartment.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Department>>(structure,HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	} 
	
	public ResponseEntity<ResponseStructure<Department>> verifyDepartment(long phone, String password){
		ResponseStructure<Department> structure=new ResponseStructure<>();
		Optional<Department> recDepartment=dao.verifyDepartment(phone, password);
		if(recDepartment.isPresent()) {
			structure.setMessage("Department Verified Succesfully");
			structure.setData(recDepartment.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Department>>(structure,HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	} 
	
	
}
