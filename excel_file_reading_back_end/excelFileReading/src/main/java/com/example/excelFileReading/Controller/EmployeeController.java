package com.example.excelFileReading.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.excelFileReading.Entity.Employee;
import com.example.excelFileReading.Entity.EmployeeSalary;
import com.example.excelFileReading.Service.EmployeeSalaryService;
import com.example.excelFileReading.Service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeSalaryService employeeSalaryService;
	
	@Autowired
	EmployeeService employeeService;
	
	
	@PostMapping("/post")
	 public ResponseEntity<String> uploadExcelFile(@PathVariable("file") MultipartFile file) {
        try {
//            List<Employee> employees = employeeService.postEmp(file, "employee");
            List<EmployeeSalary> employeeSalaries = employeeSalaryService.postEmpSalary(file, "employee");

            // You can process the result as needed

            return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error uploading the file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	

}
