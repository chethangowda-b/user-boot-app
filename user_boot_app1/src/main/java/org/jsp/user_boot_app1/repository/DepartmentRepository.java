package org.jsp.user_boot_app1.repository;

import java.util.Optional;

import org.jsp.user_boot_app1.dto.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	@Query("select d from Department d where d.email=?1 and d.password=?2")
	Optional<Department> verifyDepartment(String email,String password);
	
	@Query("select d from Department d where d.phone=?1 and d.password=?2")
	Optional<Department> verifyDepartment (long phone,String password);
}
