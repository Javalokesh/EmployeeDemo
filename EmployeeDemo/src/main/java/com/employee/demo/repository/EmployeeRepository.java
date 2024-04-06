package com.employee.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  List<Employee> findByEmployeeId(long employeeId);

  List<Employee> findByFirstName(String firstName);
}
