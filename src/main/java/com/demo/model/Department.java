package com.demo.model;

import com.revanate.annotations.Column;
import com.revanate.annotations.Entity;
import com.revanate.annotations.Id;

@Entity
public class Department {
	@Id(columnName = "dept_id", autoIndex = "auto")
	@Column(columnName = "dept_id")
	private int id;
	
	@Column(columnName = "name")
	private String name;
}
