package com.employee.demo.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class TaxCalculator {

	public static double calculateTax(double salary) {
		double tax = 0;

		if (salary <= 250000) {
			tax = 0;
		} else if (salary > 250000 && salary <= 500000) {
			tax = (salary - 250000) * 0.05;
		} else if (salary > 500000 && salary <= 1000000) {
			tax = 12500 + (salary - 500000) * 0.1;
		} else {
			tax = 12500 + 50000 + (salary - 1000000) * 0.2;
		}

		return Math.floor(tax *100)/100;
		
	}

	public static double caculateCessAmountIfApplicable(Double salary) {

		// Calculate cess if applicable
		if (salary > 2500000) {
			double excessAmount = salary - 2500000;
			return excessAmount * 0.02;
		}

		return 0.0;

	}

	public static double calculateTotalSalary(Double yearlySalary, LocalDate doj) {

		double totalSalary = 0;

		// Get the current year and month
		int currentYear = LocalDate.now().getYear();

		// Determine the start and end dates of the financial year (April 1st to March
		// 31st)
		LocalDate startFinancialYear = LocalDate.of(currentYear - 1, Month.APRIL, 1);
		LocalDate endFinancialYear = LocalDate.of(currentYear, Month.MARCH, 31);
		LocalDate startOfMonth = startFinancialYear;

		// Check if the date of joining falls within the financial year period
		if (doj.isAfter(startFinancialYear) && doj.isBefore(endFinancialYear)) {

				startOfMonth = LocalDate.of(currentYear-1, doj.getMonth(), doj.getDayOfMonth());

		}

		// Calculate the number of working months (
		long workingMonths = ChronoUnit.MONTHS.between(startOfMonth.withDayOfMonth(1),
				endFinancialYear.withDayOfMonth(1)) + 1;

		// Calculate the total salary considering the working months and LOP
		totalSalary = (yearlySalary / 12) * workingMonths;
		return Math.floor(totalSalary *100)/100;

	}
}
