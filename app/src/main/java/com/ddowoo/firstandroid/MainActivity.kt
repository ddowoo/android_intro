package com.ddowoo.firstandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ddowoo.firstandroid.ui.theme.FirstAndroidTheme

// Activity = 앱 실행시 화면에 보이는 전체
class MainActivity : ComponentActivity() {
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
                    Greeting("And")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hell $name!",
        modifier = modifier
    )
}

// @Preview 애플리케이션을 실행하지 않고 화면이 바뀌는지 확인할 수 있음
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstAndroidTheme {
        Greeting("Android")
    }
}