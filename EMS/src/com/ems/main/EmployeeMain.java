package com.ems.main;

import java.util.List;

import com.ems.dto.Employee;
import com.ems.exception.EmployeeNotFoundException;
import com.ems.service.EmployeeService;
import com.ems.service.EmployeeServiceImpl;

public class EmployeeMain {

	public static void main(String[] args) {
		
		EmployeeService eService = new EmployeeServiceImpl();
		
		// add employees
		eService.addEmployee(new Employee(1111, "Micheal", "Sales", 28));
		eService.addEmployee(new Employee(2222, "Samuel", "Technology", 25));
		eService.addEmployee(new Employee(3333, "John", "Operations", 30));
		
		// show all employees
		List<Employee> employeeList = eService.showAllEmployees();
		
		for(Employee e: employeeList) {
			System.out.println("ID: " + e.getId() + " | Name: " + e.getName() + " | Department: " + e.getDepartment() + " | Days Attended: " + e.getDaysAttended());
		}
		
		// delete an employee
		eService.deleteEmployee(1111);
		
		// find an employee
		try {
			Employee emp = eService.findEmployee(new Employee(2222, "Samuel", "Technology", 25));
			System.out.println("Employee ID: " + emp.getId() + " | Name: " + emp.getName());
		} catch (EmployeeNotFoundException e1) {
			e1.printStackTrace();
		}
		
		

	}

}
