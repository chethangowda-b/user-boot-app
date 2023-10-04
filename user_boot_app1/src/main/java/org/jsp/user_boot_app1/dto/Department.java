package org.jsp.user_boot_app1.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String location;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private long phone;
	@Column(nullable = false)
	private String password;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "dept")
	private List<Employee> emps;
}
