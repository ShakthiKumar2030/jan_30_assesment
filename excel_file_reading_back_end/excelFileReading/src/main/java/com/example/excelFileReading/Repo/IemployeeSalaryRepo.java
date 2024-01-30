package com.example.excelFileReading.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.excelFileReading.Entity.EmployeeSalary;

public interface IemployeeSalaryRepo extends JpaRepository<EmployeeSalary, Long> {

}
