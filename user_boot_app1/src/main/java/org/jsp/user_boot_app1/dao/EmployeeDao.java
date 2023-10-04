package org.jsp.user_boot_app1.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.user_boot_app1.dto.Employee;
import org.jsp.user_boot_app1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepository empRepo;
	
	public Employee saveEmp(Employee emp) {
		return empRepo.save(emp);
	}
	
	public Employee updateEmp(Employee emp) {
		return empRepo.save(emp);
	}
	
	public Optional<Employee> findById(int id){
		return empRepo.findById(id);
	}
	
	public List<Employee> findAll(){
		return empRepo.findAll();
	}
	
	public boolean deleteEmpl(int id) {
		Optional<Employee> recEmpl= empRepo.findById(id);
		if(recEmpl.isPresent()) {
			empRepo.delete(recEmpl.get());
			return true;
		}
		return false;
	}
	
	public List<Employee> findEmplByDepartmentId(int dept_id) {
		return empRepo.findEmplByDepartmentId(dept_id);
	}
	
	public Optional<Employee> verifyEmp(String email,long phone){
		return empRepo.verifyEmployee(email, phone);
	}
}
