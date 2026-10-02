package com.example.practice.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.icons.AppIcons

data class Project(
    val title: String,
    val description: String,
    val formattedDateTime: String
)

@Composable
fun ProjectCard(
    project: Project,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .background(Color(0xFFE87457))
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = AppIcons.Check,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .border(
                        width = 1.5.dp,
                        color = Color.White,
                        shape = CircleShape
                    )
                    .padding(2.dp)
            )
            Row(
                modifier = Modifier
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = project.title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                )
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = AppIcons.MoreVert,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
        Text(
            text = project.description,
            color = Color.White,
            modifier = Modifier
                .padding(start = 36.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = project.formattedDateTime,
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.End)
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun ProjectCardPreview() {
    ProjectCard(
        project = Project(
            title = "Project X",
            description = """
                Bacon ipsum dolor amet meatloaf andouille landjaeger, turducken turkey chuck flank tongue. Alcatra chislic shankle strip steak ball tip beef venison. Doner spare ribs shank ham hock, turkey filet mignon buffalo rump cupim corned beef drumstick. Pork corned beef pig shoulder cow sausage picanha prosciutto doner beef ribs brisket bacon.
            """.trimIndent(),
            formattedDateTime = "Mar 5, 10:00"
        )
    )
}