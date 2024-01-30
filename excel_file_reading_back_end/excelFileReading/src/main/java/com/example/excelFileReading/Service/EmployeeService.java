package com.example.excelFileReading.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.excelFileReading.Repo.IemployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	IemployeeRepo employeeRepo;

//	private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
//
//	public List<Employee> postEmp(MultipartFile file, String sheetName) {
//		List<Employee> emp = new ArrayList<>();
//
//		try (InputStream inputStream = file.getInputStream()) {
//			Workbook workbook = WorkbookFactory.create(inputStream);
//
//			if (workbook != null) {
//				Sheet sheet = workbook.getSheet(sheetName);
//
//				if (sheet != null) {
//					int rowCount = sheet.getLastRowNum() + 1;
//
//					for (int i = 1; i < rowCount; i++) {
//						Row row = sheet.getRow(i);
//
//						if (row != null) {
//							Long empId = (long) row.getCell(0).getNumericCellValue();
//							String empName = row.getCell(1).getStringCellValue();
//							String project = row.getCell(2).getStringCellValue();
//
//							Employee employeeDetails = new Employee();
//							employeeDetails.setEmpId(empId);
//							employeeDetails.setEmpName(empName);
//							employeeDetails.setProject(project);
//
//							Employee empResult = employeeRepo.save(employeeDetails);
//							emp.add(empResult);
//						}
//					}
//				} else {
//					log.error("Sheet with name '{}' does not exist in the workbook.", sheetName);
//				}
//			} else {
//				log.error("Workbook is null.");
//			}
//		} catch (Exception e) {
//			log.error("Error processing Excel data: {}", e.getMessage());
//		}
//		return emp;
//	}
}
