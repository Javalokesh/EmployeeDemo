package com.employee.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.demo.dto.EmployeeTaxInfoDto;
import com.employee.demo.model.Employee;
import com.employee.demo.repository.EmployeeRepository;
import com.employee.demo.util.TaxCalculator;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<EmployeeTaxInfoDto> prepareFinInformation(List<Employee> employees) {

		List<EmployeeTaxInfoDto> employeesTaxInfo = new ArrayList<EmployeeTaxInfoDto>();

		// Calculate tax for each employee and store in the separate list
		employees.stream().forEach(employee -> {
			if (employee.getSalary() != null && employee.getDoj() != null) {
				double totalSalary = TaxCalculator.calculateTotalSalary(employee.getSalary(),
						employee.getDoj().toLocalDate());
				double taxAmount = TaxCalculator.calculateTax(totalSalary);
				double cessAmount = TaxCalculator.caculateCessAmountIfApplicable(totalSalary);
				employeesTaxInfo.add(new EmployeeTaxInfoDto(employee.getEmployeeId(), employee.getFirstName(),
						totalSalary, taxAmount, cessAmount));
			} else {
				System.out.println("Skipping calculation for employee " + employee.getFirstName()
						+ " due to missing salary or date of joining.");
			}
		});

		return employeesTaxInfo;

	}
}
