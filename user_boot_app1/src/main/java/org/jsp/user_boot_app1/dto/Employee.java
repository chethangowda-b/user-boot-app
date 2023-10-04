package org.jsp.user_boot_app1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String desg;
	private double salary;
	private int age;
	@Column(unique = true)
	private long phone;
	private String email;
	@ManyToOne
	@JoinColumn(name = "dept_id")
	@JsonIgnore
	private Department dept;
}
