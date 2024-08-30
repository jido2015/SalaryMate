package com.blinx.feature_salary_calculation.domain.models

/** Entities Layer (Domain Layer)
 *
 * This layer contains the core business logic and models called SalaryCalculator,
 * which handles all the calculations.
 * */

// 40 Represents the standard number of work hours in a week.
// 52 Represents the number of weeks in a year, excluding holidays.
// 50 Represents the number of weeks in a year, including holidays.
// TimeOffWeeks represents the number of weeks off in a year.
// HourlyRate represents the hourly rate of the employee.
// YearlySalary represents the yearly salary of the employee.
// IncludeHolidays indicates whether holidays are included in the calculation.

class SalaryCalculator(
    private val hourlyRate: Double,
    private val yearlySalary: Double,
    private val includeHolidays: Boolean,
    private val timeOffWeeks: Double

) {
    fun calculateHourlyRate(): Double {
        val weeksPerYear = if (includeHolidays) 52.0 else 50.0
        val effectiveWeeks = weeksPerYear - timeOffWeeks
        return if (yearlySalary >  0) yearlySalary / (40 * effectiveWeeks) else hourlyRate
    }

    fun calculateYearlyRate(): Double {
        val weeksPerYear = if (includeHolidays) 52.0 else 50.0
        val effectiveWeeks = weeksPerYear - timeOffWeeks
        return if (hourlyRate > 0) hourlyRate * 40 * effectiveWeeks else yearlySalary
    }

    fun calculateMonthlyRate(): Double {
        return calculateYearlyRate() / 12
    }
}