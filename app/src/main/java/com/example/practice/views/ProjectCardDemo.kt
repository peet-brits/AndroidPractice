package com.example.practice.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.ui.theme.PracticeTheme
import com.example.practice.views.solution.Project
import com.example.practice.views.solution.ProjectCard

@Composable
fun ProjectCardDemo(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ProjectScreen(
                project = ProjectData(
                    heading = "My Solution",
                    description = "This is a preview.",
                    formattedDateTime = "Mar 5, 10:00"
                )
            )
        }
        item {
            ProjectCard(
                project = Project(
                    title = "Sample Solution",
                    description = "This is a preview.",
                    formattedDateTime = "Mar 5, 10:00"
                )
            )
        }
        item {
            ProjectScreen(
                project = ProjectData(
                    heading = "My ${baconIpsum.lowercase()}",
                    description = baconIpsum,
                    formattedDateTime = "Mar 5, 10:00"
                )
            )
        }
        item {
            ProjectCard(
                project = Project(
                    title = "Sample ${baconIpsum.lowercase()}",
                    description = baconIpsum,
                    formattedDateTime = "Mar 5, 10:00"
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProjectCardDemoPreview() {
    PracticeTheme {
        ProjectCardDemo()
    }
}