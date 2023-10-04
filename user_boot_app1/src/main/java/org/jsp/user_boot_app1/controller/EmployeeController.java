package org.jsp.user_boot_app1.controller;

import java.util.List;

import org.jsp.user_boot_app1.dto.Employee;
import org.jsp.user_boot_app1.dto.ResponseStructure;
import org.jsp.user_boot_app1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employees/{user_id}")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee emp,@PathVariable int user_id){
		return service.saveEmployee(emp,user_id);
	}
	
	@PutMapping("/employees/{user_id}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee emp,@PathVariable int user_id){
		return service.saveEmployee(emp,user_id);
	}
	
	@GetMapping("employees/{id}")
	public ResponseEntity<ResponseStructure<Employee>> findById(@PathVariable int id){
		return service.findById(id);
	}
	
	@DeleteMapping("employees/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteEmployee(@PathVariable int id){
		return service.deleteEmployee(id);
	}
	
	@GetMapping("employees/bydepartment-id/{id}")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmpByDeptId(@PathVariable int id){
		return service.findByDepartmentId(id);
	}
}
