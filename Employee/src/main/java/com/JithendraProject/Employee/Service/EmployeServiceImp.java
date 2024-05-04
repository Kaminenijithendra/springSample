package com.JithendraProject.Employee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JithendraProject.Employee.Entity.Employee_Entity;
import com.JithendraProject.Employee.Repository.EmployeeRepository;
@Service
public class EmployeServiceImp implements EmployeService {

	@Autowired
	EmployeeRepository repo;
	@Override
	public Employee_Entity createEmploye(Employee_Entity employe) {


		Employee_Entity saved_employe=repo.save(employe);
		return saved_employe;
	}

	@Override
	public List<Employee_Entity> getAllEmployeeDetails() {
		List<Employee_Entity> employee_list=repo.findAll();
		return employee_list;
	}
	@Override
	public Employee_Entity updateEmployee(Long Id, Employee_Entity employee) {
		Employee_Entity existingEmployee = repo.findById(Id).orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + Id));


        // Update the properties of the existing employee
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setMobileNO(employee.getMobileNO());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setGender(employee.getGender());

        // Save and return the updated employee
        return repo.save(existingEmployee);
	}

	@Override
	public void deleteEmployee(Long Id) {
		repo.deleteById(Id);
		
	}

}
