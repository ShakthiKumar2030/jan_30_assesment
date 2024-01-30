package com.example.excelFileReading.Service;

import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.excelFileReading.Entity.Employee;
import com.example.excelFileReading.Entity.EmployeeSalary;
import com.example.excelFileReading.Repo.IemployeeSalaryRepo;



@Service
public class EmployeeSalaryService {
	
	@Autowired
	IemployeeSalaryRepo employeeSalaryRepo;
	
//	private static final Logger log=LoggerFactory.getLogger(EmployeeSalary.class);
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeSalaryService.class);
	
	public List<EmployeeSalary> postEmpSalary(MultipartFile file, String sheetName) {
        List<EmployeeSalary> empSalaries = new ArrayList<>();

        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(inputStream);

            if (workbook != null) {
                Sheet sheet = workbook.getSheet(sheetName);

                if (sheet != null) {
                    int rowCount = sheet.getLastRowNum() + 1;

                    for (int i = 1; i < rowCount; i++) {
                        Row row = sheet.getRow(i);

                        if (row != null) {
                            Long empSalId = (long) row.getCell(0).getNumericCellValue();
                            Date salaryCreditedDate = new Date(row.getCell(1).getDateCellValue().getTime());
                            Float amount = (float) row.getCell(2).getNumericCellValue();
                            // Assuming the empId is a Long, adjust accordingly
                            Long empId = (long) row.getCell(3).getNumericCellValue();

                            EmployeeSalary employeeSalary = new EmployeeSalary();
                            employeeSalary.setEmpSalId(empSalId);
                            employeeSalary.setSalaryCreditedDate(salaryCreditedDate);
                            employeeSalary.setAmount(amount);
                            employeeSalary.setEmpId(empId);

//                            Employee employee = new Employee();
//                            employee.setEmpId(empId);
//                            employeeSalary.setEmployee(employee);

                            EmployeeSalary salaryResult = employeeSalaryRepo.save(employeeSalary);
                            empSalaries.add(salaryResult);
                        }
                    }
                } else {
                    log.error("Sheet with name 'employeeSalary' does not exist in the workbook.");
                }
            } else {
                log.error("Workbook is null.");
            }
        } catch (Exception e) {
            log.error("Error processing Excel data: {}", e.getMessage());
        }
        return empSalaries;
    }

}
