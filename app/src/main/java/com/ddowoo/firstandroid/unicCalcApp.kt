package com.ddowoo.firstandroid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitCalc(modifier: Modifier = Modifier){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        var inputValue by remember { mutableStateOf("") }
        var outputValue by remember { mutableStateOf("") }
        var inputUnit by remember { mutableStateOf("Meters") }
        var outputUnit by remember { mutableStateOf("Meters") }
        var isInOpened by remember { mutableStateOf(false) }
        var isOutOpened by remember { mutableStateOf(false) }
        var conversionFactor = remember { mutableStateOf(1.00) }
        var oConversionFactor = remember { mutableStateOf(1.00) }

        fun convertUnits (){

            // ?: elvis operator js의 ?? 와 같은 역할
            val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
            val result = (inputValueDouble * conversionFactor.value * 100.0 / oConversionFactor.value).roundToInt() / 100.0
            outputValue = result.toString();
        }



        Text("Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange = {
            inputValue = it
            convertUnits()
        })
        Spacer(modifier = Modifier.height(16.dp))
        Row (
        ) {
            Box{
                Button(onClick = {
                    isInOpened = !isInOpened
                }) {
                    Text(inputUnit)
                    // contentDescription 접근성 설명
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                // expanded = false 초기 닫아두기
                DropdownMenu(expanded = isInOpened, onDismissRequest = {
                    isInOpened = false
                }) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = {
                            isInOpened = false
                            inputUnit = "Centimeters"
                            conversionFactor.value = 0.01
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            isInOpened = false
                            inputUnit = "Meters"
                            conversionFactor.value = 1.0
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            isInOpened = false
                            inputUnit = "Feet"
                            conversionFactor.value = 0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Milimeters") },
                        onClick = {
                            isInOpened = false
                            inputUnit = "Milimeters"
                            conversionFactor.value = 0.001
                            convertUnits()
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                Button(onClick = {
                    isOutOpened = !isOutOpened
                }) {
                    Text(outputUnit)
                    // contentDescription 접근성 설명
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                // expanded = false 초기 닫아두기
                DropdownMenu(expanded = isOutOpened, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = {
                            isOutOpened = false
                            outputUnit = "Centimeters"
                            oConversionFactor.value = 0.01
                            convertUnits()

                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            isOutOpened = false
                            outputUnit = "Meters"
                            oConversionFactor.value = 1.00
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            isOutOpened = false
                            outputUnit = "Feet"
                            oConversionFactor.value = 0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Milimeters") },
                        onClick = {
                            isOutOpened = false
                            inputUnit = "Milimeters"
                            oConversionFactor.value = 0.001
                            convertUnits()
                        }
                    )
                }
            }


        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Result : " + outputValue + " " + outputUnit,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}
