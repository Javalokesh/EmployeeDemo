package com.employee.demo.dto;

public class EmployeeTaxInfoDto {
	
    private long employeeId;
    private String name;
    private double totalSalary;
    private double tax;
    private double cess;

    public EmployeeTaxInfoDto(long employeeId, String name, double totalSalary, double tax, double cess) {
        this.employeeId = employeeId;
        this.name = name;
        this.totalSalary = totalSalary;
        this.tax = tax;
        this.cess = cess;
    }
    
    public long getEmployeeId() {
		return employeeId;
	}

	public String getName() {
        return name;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public double getTax() {
        return tax;
    }

    public double getCess() {
        return cess;
    }

}
