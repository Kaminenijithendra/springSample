package com.JithendraProject.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JithendraProject.Employee.Entity.Employee_Entity;
import com.JithendraProject.Employee.Service.EmployeService;

@RestController
@RequestMapping("/employe")
public class EmployeeController {
	
	@Autowired
	EmployeService service;
	
	
	//creating the employee
	@PostMapping("/create")
	public Employee_Entity createEmploye(@RequestBody Employee_Entity employe) {
		Employee_Entity createEmploye= service.createEmploye(employe);
		return createEmploye;
		
	}
	@GetMapping("/getallemployees")
	public List<Employee_Entity> getAllEmployeDetails(){
		List<Employee_Entity> allemployeedetails= service.getAllEmployeeDetails();
		return allemployeedetails;
	}
	@PutMapping("/updatebyid")
	public ResponseEntity<Employee_Entity> updateEmployee(@PathVariable Long id, @RequestBody Employee_Entity employee) {
        Employee_Entity updatedEmployee =service.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Employee with id " + id + " deleted successfully");
    }
}
