package org.jsp.user_boot_app1.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.user_boot_app1.dto.Department;
import org.jsp.user_boot_app1.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {
	@Autowired
	private DepartmentRepository deptRepo;
	
	public Department saveDepartment(Department dept) {
		return deptRepo.save(dept);
	}
	
	public Department updateDepartment (Department dept)
	{
		return deptRepo.save(dept);
	}
	
	public Optional<Department> findById(int id){
		return deptRepo.findById(id);
	}
	
	public void deleteDepartment(int id) {
		deptRepo.deleteById(id);
	}
	
	public List<Department> findAll(){
		return deptRepo.findAll();
	}
	
	public Optional<Department> verifyDepartment(String email,String password){
		return deptRepo.verifyDepartment(email, password);
	}
	
	public Optional<Department> verifyDepartment(long phone,String password){
		return deptRepo.verifyDepartment(phone,password);
	}
}
