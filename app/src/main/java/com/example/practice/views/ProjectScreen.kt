package com.example.practice.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.icons.AppIcons
import com.example.practice.ui.theme.PracticeTheme

val Orange = Color(0xFFE4694D)

@Composable
fun ProjectScreen(
    modifier: Modifier = Modifier,
    heading: String = "Project X",
    description: String = "This is a short description",
    timestamp: String = "Mar 5, 10:00"
) {
    Column(
        modifier = modifier
            .background(
                color = Orange,
                shape = RoundedCornerShape(5.dp)
            )
    ) {
        Row {
            Image(
                imageVector = AppIcons.CheckCircle,
                contentDescription = "Check"
            )
            Column(
                modifier = Modifier
                    .width(IntrinsicSize.Max),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = heading
                    )
                    Image(
                        imageVector = AppIcons.MoreHoriz,
                        contentDescription = "More"
                    )
                }
                Text(
                    text = description
                )
            }
        }
        Text(
            modifier = Modifier
                .align(Alignment.End),
            text = timestamp
        )
    }
}

@Preview(showBackground = false, name = "Simple")
@Composable
fun ProjectScreenPreviewSimple() {
    PracticeTheme {
        ProjectScreen(
            heading = "Project X",
            description = "This is a short description",
            timestamp = "Mar 5, 10:00"
        )
    }
}

@Preview(showBackground = false, name = "Overflow")
@Composable
fun ProjectScreenPreviewOverflow() {
    PracticeTheme {
        ProjectScreen(
            heading = "Project X",
            description = "Bacon ipsum dolor amet pork chop flank landjaeger cupim chicken ham, tail kielbasa swine burgdoggen spare ribs meatball. Tongue burgdoggen shank meatloaf ham hock tenderloin turkey, buffalo spare ribs. Capicola tri-tip spare ribs, drumstick landjaeger meatloaf chicken pork chop ground round turducken beef ribs shankle ribeye. Hamburger burgdoggen shank, tri-tip jerky prosciutto rump brisket meatloaf buffalo beef ribs short ribs t-bone sausage.",
            timestamp = "Mar 5, 10:00"
        )
    }
}