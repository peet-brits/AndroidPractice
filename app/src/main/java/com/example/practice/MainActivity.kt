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
import com.example.practice.theme.ThemeDemo
import com.example.practice.ui.theme.PracticeTheme
import com.example.practice.views.ProjectCardDemo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Demo(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Demo(modifier: Modifier = Modifier) {
    //ProjectCardDemo(modifier)
    //ThemeDemo(modifier)
}

@Preview(showBackground = true, heightDp = 1200)
@Composable
fun DemoPreview() {
    PracticeTheme {
        Demo()
    }
}