package org.jsp.user_boot_app1.controller;

import java.util.List;

import org.jsp.user_boot_app1.dto.Department;
import org.jsp.user_boot_app1.dto.ResponseStructure;
import org.jsp.user_boot_app1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class DepartmentController {
	 
	@Autowired
	private DepartmentService service;
	
	@PostMapping("/departments")
	public ResponseEntity<ResponseStructure<Department>> saveDepartment(@RequestBody Department dept){
		return service.saveDepartment(dept);
	}
	
	@PutMapping("/departments")
	public ResponseEntity<ResponseStructure<Department>> updateDepartment(@RequestBody Department dept){
	return service.updateDepartment(dept);
	}
	
	@GetMapping("/departments/{id}")
	public ResponseEntity<ResponseStructure<Department>> findById(@PathVariable int id){
		return service.findById(id);
	}
	
	@DeleteMapping("departments/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteDepartment(@PathVariable int id){
		return service.deleteDepartment(id);
	}
	
	@GetMapping("departments")
	public ResponseEntity<ResponseStructure<List<Department>>> findAll(){
		return service.findAll();
	}
	
	@PostMapping("departments/verifyByEmail")
	public ResponseEntity<ResponseStructure<Department>> verifyDepartment(@RequestParam String email,@RequestParam String password){
		return service.verifyDepartment(email, password);
	}
	
	@PostMapping("departments/verifyByPhone")
	public ResponseEntity<ResponseStructure<Department>> verifyDepartment(@RequestParam long phone,@RequestParam String password){
		return service.verifyDepartment(phone, password);
	}

}
