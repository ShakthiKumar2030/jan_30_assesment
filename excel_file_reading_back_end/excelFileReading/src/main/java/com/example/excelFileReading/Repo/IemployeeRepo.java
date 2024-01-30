package com.example.excelFileReading.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.excelFileReading.Entity.Employee;

public interface IemployeeRepo extends JpaRepository<Employee, Long> {

}
