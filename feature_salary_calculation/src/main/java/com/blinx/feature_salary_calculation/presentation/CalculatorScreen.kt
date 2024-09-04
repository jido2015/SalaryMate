package com.blinx.feature_salary_calculation.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import java.text.DecimalFormat


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorScreen(salaryViewModel: SalaryViewModel = viewModel()) {
    var salaryInput by remember { mutableStateOf("") }
    var isHourly by remember { mutableStateOf(true) }
    var includeHolidays by remember { mutableStateOf(true) }

    val decimalFormat = DecimalFormat("#,##0.00")

    val salary = salaryInput.toDoubleOrNull() ?: 0.0

    val salaryResult = if (isHourly) {
        salaryViewModel.calculateSalary(salary, 0.0, includeHolidays)
    } else {
        salaryViewModel.calculateSalary(0.0, salary, includeHolidays)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Salary Calculator") })
        }
    ) {
        innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = salaryViewModel.formatInput(salaryInput),
                onValueChange = {
                    salaryInput = it.replace(",","") // Format and update the raw input

                },
                label = { Text("Enter Salary") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Salary Type:")
                Spacer(modifier = Modifier.width(8.dp))
                RadioButton(selected = isHourly, onClick = { isHourly = true })
                Text("Hourly")
                Spacer(modifier = Modifier.width(8.dp))
                RadioButton(selected = !isHourly, onClick = { isHourly = false })
                Text("Yearly")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Checkbox(checked = includeHolidays, onCheckedChange = { includeHolidays = it })
            Text("Include Holidays")

            Spacer(modifier = Modifier.height(16.dp))

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {}) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Hourly Rate: \$${decimalFormat.format(salaryResult.hourlyRate)}")
                    Text("Monthly Rate: \$${decimalFormat.format(salaryResult.monthlyRate)}")
                    Text("Yearly Rate: \$${decimalFormat.format(salaryResult.yearlyRate)}")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatorScreen()
}
