package com.example.excelFileReading.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "employee_salary")
public class EmployeeSalary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_sal_id")
	private Long empSalId;
	
	@Column(name = "salary_credited_date")
	private Date salaryCreditedDate;
	
	@Column(name = "amount")
	private Float amount;
	
	@Column(name = "emp_id")
	private Long empId;
	
//	@ManyToOne
//	@JoinColumn(name = "emp_id", nullable = false)
//	private Employee employee;


}
