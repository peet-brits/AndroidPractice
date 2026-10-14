package com.example.practice.theme

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.ui.theme.PracticeTheme
import com.example.practice.ui.theme.Yarndings12

@Composable
fun ThemeDemo(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("Jimmy") }
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
            value = name,
            onValueChange = { name = it },
        )
        Button(onClick = {}) { Text("Hello") }
        HorizontalDivider(
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.primary,
        )
        Text(
            text = "abcdefghijklmnopqrstuvwxyz",
            fontFamily = Yarndings12,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
        )
        Text(
            text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            fontFamily = Yarndings12,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
        )
        Text(
            text = "0123456789",
            fontFamily = Yarndings12,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
        )
    }
}

@Preview(showBackground = true)
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES) // partly working - ???
@Composable
fun GreetingPreview() {
    PracticeTheme {
        ThemeDemo()
    }
}