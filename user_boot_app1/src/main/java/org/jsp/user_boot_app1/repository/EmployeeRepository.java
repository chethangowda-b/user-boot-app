package org.jsp.user_boot_app1.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.user_boot_app1.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query("select e from Employee e where e.email=?1 and e.phone=?2")
	Optional<Employee> verifyEmployee(String email,long phone);
	
	@Query("select e from Employee e where e.dept.id=?1")
	List<Employee> findEmplByDepartmentId(int dept_id);
}
