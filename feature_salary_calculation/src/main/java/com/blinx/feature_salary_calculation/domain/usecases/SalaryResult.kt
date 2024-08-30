package com.blinx.feature_salary_calculation.domain.usecases

data class SalaryResult(
    val hourlyRate: Double,
    val yearlyRate: Double,
    val monthlyRate: Double
)