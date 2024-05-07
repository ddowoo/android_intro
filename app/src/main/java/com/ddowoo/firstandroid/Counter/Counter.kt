package com.ddowoo.firstandroid.Counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Counter(viewModel: CounterViewModel){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "now : ${viewModel.counter.value}")
        Spacer(modifier = Modifier.height(4.dp))
        Row {
            Button(onClick = { viewModel.decrement() }) {
                Text(text = "감소")
            }
            Spacer(modifier = Modifier.width(4.dp))
            Button(onClick = { viewModel.increment() }) {
                Text(text = "증가")
            }
        }
    }
}