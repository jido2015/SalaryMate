package com.blinx.feature_salary_calculation.presentation

import androidx.lifecycle.ViewModel
import com.blinx.feature_salary_calculation.domain.usecases.CalculateSalaryUseCase
import com.blinx.feature_salary_calculation.domain.usecases.FormatTextUseCase
import com.blinx.feature_salary_calculation.domain.usecases.SalaryResult

/** View Models Layer (Presentation Layer)
 * This layer contains the UI logic. It interacts with the use cases and
 * displays the data to the user. The ViewModel will
 * handle the interaction between the UI and the use cases.
 * */
class SalaryViewModel: ViewModel() {
    private val calculateSalaryUseCase = CalculateSalaryUseCase()
    private val formatTextUseCase = FormatTextUseCase()

    fun calculateSalary(
        hourlyRate: Double,
        yearlySalary: Double,
        includeHolidays: Boolean
    ): SalaryResult {
        return calculateSalaryUseCase.execute(hourlyRate, yearlySalary, includeHolidays )
    }

    fun formatInput(rawInput: String): String {
        return formatTextUseCase.execute(rawInput)
    }
}