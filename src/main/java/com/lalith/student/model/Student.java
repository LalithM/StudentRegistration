package com.lalith.student.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="student")
@Entity
@Data
public class Student {
	
	@Id
	@Column(name="registration_number")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long rollNo;
	
	@Column(name="student_name")
	private String name;
	
	private Integer age;
	
	private String gender;
	
	@Column(name="student_year")
	private Integer year;
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
	@Column(name="updated_date")
	private LocalDate updatedDate;
	
	@Column(name="is_active")
	private Boolean isActive=Boolean.TRUE;
	
	

}
