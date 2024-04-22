package com.ddowoo.firstandroid

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.ddowoo.firstandroid.ui.theme.FirstAndroidTheme

// Activity = 앱 실행시 화면에 보이는 전체
class MainActivity : ComponentActivity() {

    //KOTLIN 정리
    // INTENGER





    // onCreate 이 액티비티가 생길떄 실행되는 생명주기
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAndroidTheme {
                // Surface는 백그라운드를 위한것 (Activity)
                Surface(
                    modifier = Modifier.fillMaxSize(), // 화면 전체를 띄워줘야 한다고 알려줌
                    color = MaterialTheme.colorScheme.background
                ) {
                    Header()
                }


            }
        }
    }

    @Composable
    fun CaptainGame(){
        val treasuresFound = remember{ mutableStateOf(0) }
        val direction = remember {
            mutableStateOf("North")
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(modifier: Modifier = Modifier){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        var inputValue by remember { mutableStateOf("") }
        var outputValue by remember { mutableStateOf("") }
        var inputUnit by remember { mutableStateOf("Centimeters") }
        var outputUnit by remember { mutableStateOf("Meters") }
        var isInOpened by remember { mutableStateOf(false) }
        var isOutOpened by remember { mutableStateOf(false) }
        var conversionFactor by remember { mutableStateOf(false) }


        Text("Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange = {
            inputValue = it
            outputValue = it
        })
        Spacer(modifier = Modifier.height(16.dp))
        Row (
        ) {
            Box{
                Button(onClick = {
                    isInOpened = !isInOpened
                }) {
                    Text("Selecct")
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
                            inputUnit = "Centimeters"
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            inputUnit = "Meters"
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            inputUnit = "Feet"
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                Button(onClick = { /*TODO*/ }) {
                    Text("Selecct")
                    // contentDescription 접근성 설명
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                // expanded = false 초기 닫아두기
                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = { /*TODO*/ }
                    )
                }
            }


        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Result : " + outputValue)

    }
}


// @Preview 애플리케이션을 실행하지 않고 화면이 바뀌는지 확인할 수 있음
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Header()
}