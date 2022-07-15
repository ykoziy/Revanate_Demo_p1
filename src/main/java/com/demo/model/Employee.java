package com.demo.model;

import com.revanate.annotations.Column;
import com.revanate.annotations.Entity;
import com.revanate.annotations.ForeignKey;
import com.revanate.annotations.Id;

@Entity
public class Employee {
	@Id(columnName = "emp_id", autoIndex = "auto")
	@Column(columnName = "emp_id")
	private int id;
	
	@Column(columnName = "username")
	private String username;
	
	@ForeignKey(columnName = "dept_fk")
	private Department employeeDept;
}
