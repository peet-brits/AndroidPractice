package com.example.practice.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practice.ui.theme.PracticeTheme

@Composable
fun ThemeDemo(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Display Small",
            style = MaterialTheme.typography.displaySmall,
        )
        Text(
            text = "Headline Small",
            style = MaterialTheme.typography.headlineSmall,
        )
        Text(
            text = "Hello, my $name!",
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = "Static Display",
            onValueChange = {},
            enabled = false,
        )
        Button(onClick = {}) { Text("Hello") }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticeTheme {
        ThemeDemo("Android")
    }
}