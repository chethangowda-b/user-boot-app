package org.jsp.user_boot_app1.service;

import java.util.List;
import java.util.Optional;

import org.jsp.user_boot_app1.dao.DepartmentDao;
import org.jsp.user_boot_app1.dao.EmployeeDao;
import org.jsp.user_boot_app1.dto.Department;
import org.jsp.user_boot_app1.dto.Employee;
import org.jsp.user_boot_app1.dto.ResponseStructure;
import org.jsp.user_boot_app1.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao eDao;
	
	@Autowired
	private DepartmentDao dDao;
	
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee emp,int dept_id){
		Optional<Department> recDept= dDao.findById(dept_id);
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		if(recDept.isPresent()) {
			Department d=recDept.get();
			d.getEmps().add(emp);
			emp.setDept(recDept.get());
			dDao.updateDepartment(recDept.get());
			eDao.saveEmp(emp);
			structure.setData(emp);
			structure.setMessage("Employee added Succesfully");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	   }
	
		public ResponseEntity<ResponseStructure<Employee>> updateEmployee(Employee emp,int dept_id){
			Optional<Department> recDept=dDao.findById(dept_id);
			ResponseStructure<Employee> structure=new  ResponseStructure<>();
			if(recDept.isPresent()) {
				emp.setDept(recDept.get());
				eDao.updateEmp(emp);
				structure.setData(emp);
				structure.setMessage("Employee Details Updated");
				structure.setStatusCode(HttpStatus.CREATED.value());
				return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED);
			}
			throw new IdNotFoundException();
		}
		
		public ResponseEntity<ResponseStructure<Employee>> findById(int id){
			Optional<Employee> recEmp=eDao.findById(id);
			ResponseStructure<Employee> structure=new ResponseStructure<>();
			if(recEmp.isPresent()) {
				structure.setData(recEmp.get());
				structure.setMessage("Employee Found");
				structure.setStatusCode(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
			}
			throw new IdNotFoundException();
		}
		
		public ResponseEntity<ResponseStructure<List<Employee>>> findAll(){
			ResponseStructure<List<Employee>> structure=new ResponseStructure<>();
			structure.setData(eDao.findAll());
			structure.setMessage("Employees Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure,HttpStatus.OK);
		}
		
		public ResponseEntity<ResponseStructure<String>> deleteEmployee(int id){
			ResponseStructure<String> structure=new ResponseStructure<>();
			Optional<Employee> recEmp = eDao.findById(id);
			if(recEmp.isPresent()) {
				eDao.deleteEmpl(id);
				structure.setData("Employee Deleted");
				structure.setMessage("Employee Found");
				structure.setStatusCode(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
			}
			throw new  IdNotFoundException();			
		}
		
		public ResponseEntity<ResponseStructure<List<Employee>>> findByDepartmentId(int dept_id){
			ResponseStructure<List<Employee>> structure=new ResponseStructure<>();
			structure.setData(eDao.findEmplByDepartmentId(dept_id));
			structure.setMessage("Employee Found For Department Id");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure,HttpStatus.OK);
		}
}
