package com.blinx.feature_salary_calculation.domain.usecases

import com.blinx.feature_salary_calculation.domain.models.SalaryCalculator

/** Use Cases Layer (Application Layer)
 * This layer contains application-specific business rules.
 * Use cases orchestrate the flow of data to and from the
 * entities and often include the business logic.
 * */

class CalculateSalaryUseCase {
    fun execute(
        hourlyRate: Double,
        yearlySalary: Double,
        includeHolidays: Boolean
    ):SalaryResult  {
        val salaryCalculator = SalaryCalculator(hourlyRate, yearlySalary, includeHolidays)
        return SalaryResult(
            hourlyRate = salaryCalculator.calculateHourlyRate(),
            yearlyRate = salaryCalculator.calculateYearlyRate(),
            monthlyRate = salaryCalculator.calculateMonthlyRate()
        )

    }

}