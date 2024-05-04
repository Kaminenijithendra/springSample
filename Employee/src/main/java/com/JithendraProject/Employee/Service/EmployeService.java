package com.JithendraProject.Employee.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.JithendraProject.Employee.Entity.Employee_Entity;
@Service
public interface EmployeService {
	public Employee_Entity createEmploye(Employee_Entity employe);
	public List<Employee_Entity> getAllEmployeeDetails();
	Employee_Entity updateEmployee(Long Id, Employee_Entity employee);
	void deleteEmployee(Long Id);

}
