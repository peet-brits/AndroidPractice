package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.practice.ui.theme.PracticeTheme

// Tutorial: https://www.youtube.com/watch?v=EqCvUETekjk&list=PLQkwcJG4YTCT1LkjokmzZUFFyFVVWPuKk

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {

                        // TODO. TopAppBar. Should I be using experimental features?

                        @OptIn(ExperimentalMaterial3Api::class)
                        TopAppBar(
                            title = {
                                Text(text = "My notes")
                            },
                            navigationIcon = {
                                IconButton(onClick = { }) {
                                    Icon(

                                        // TODO. Unresolved reference 'Icons'.

                                        imageVector = Icons.Default.ArrowBack,
                                        contentDescription = "Go back"
                                    )
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        items(100) {
                            Text(
                                text = "Item $it",
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
