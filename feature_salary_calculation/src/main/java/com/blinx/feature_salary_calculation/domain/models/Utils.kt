package com.blinx.feature_salary_calculation.domain.models

import java.text.DecimalFormat

class Utils {

    fun formatText(rawInput: String): String {
        val decimalFormat = DecimalFormat("#,###")

        //Format the input every time it's updated
        val formattedInput = if (rawInput.isNotEmpty()){
            try {
                val parsedNumber = rawInput.replace(",", "").toDouble()
                decimalFormat.format(parsedNumber)
            }catch (e: NumberFormatException){
                ""
            }
        }else{
            ""
        }
        return formattedInput
    }
}