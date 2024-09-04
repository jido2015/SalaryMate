package com.blinx.feature_salary_calculation.domain.usecases

import com.blinx.feature_salary_calculation.domain.models.Utils

class FormatTextUseCase {
    fun execute(rawInput: String): String {
        return Utils().formatText(rawInput)
    }
}