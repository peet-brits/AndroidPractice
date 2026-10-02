package com.example.practice.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.icons.AppIcons
import com.example.practice.ui.theme.PracticeTheme

data class ProjectData(
    val heading: String,
    val description: String,
    val formattedDateTime: String
)

@Composable
fun ProjectScreen(
    modifier: Modifier = Modifier,
    project: ProjectData
) {
    Column(
        modifier = modifier
            .background(
                color = Color(0xFFE4694D),
                shape = RoundedCornerShape(5.dp)
            )
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = AppIcons.CheckCircle,
                contentDescription = "Check",
                tint = Color.White
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = project.heading,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 24.sp
                )
                IconButton(
                    onClick = { }
                ) {
                    Icon(
                        imageVector = AppIcons.MoreHoriz,
                        contentDescription = "More",
                        tint = Color.White
                    )
                }
            }
        }
        Text(
            modifier = Modifier
                .padding(start = 32.dp),
            text = project.description,
            color = Color.White
        )
        Text(
            modifier = Modifier
                .align(Alignment.End),
            text = project.formattedDateTime,
            color = Color.White
        )
    }
}

@Preview(showBackground = false, name = "Simple")
@Composable
fun ProjectScreenPreviewSimple() {
    PracticeTheme {
        ProjectScreen(
            project = ProjectData(
                heading = "Hello ".repeat(10),
                description = "This is a short description.",
                formattedDateTime = "Mar 5, 10:00"
            )
        )
    }
}

@Preview(showBackground = false, name = "Overflow")
@Composable
fun ProjectScreenPreviewOverflow() {
    PracticeTheme {
        ProjectScreen(
            project = ProjectData(
                heading = "Project X",
                description = baconIpsum,
                formattedDateTime = "Mar 5, 10:00"
            )
        )
    }
}