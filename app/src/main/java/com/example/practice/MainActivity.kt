package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practice.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeTheme {
                BasicScreen()
                //MaterialScreen()
            }
        }
    }
}

@Composable
private fun BasicScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Demo(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun Demo(modifier: Modifier = Modifier) {
}

@Preview(showBackground = true)
@Composable
private fun DemoPreview() {
    PracticeTheme {
        Demo()
    }
}