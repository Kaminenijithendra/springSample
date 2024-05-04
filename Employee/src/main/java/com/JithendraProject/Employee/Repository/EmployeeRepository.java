package com.JithendraProject.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JithendraProject.Employee.Entity.Employee_Entity;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee_Entity, Long> {

}
