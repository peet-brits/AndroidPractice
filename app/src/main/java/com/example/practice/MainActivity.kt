package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.icons.AppIcons
import com.example.practice.icons.AppIconsFilled
import com.example.practice.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeTheme {
                MainScreen()
            }
        }
    }
}

data class BottomNavigationItem(
    val title: String,
    //val route: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainScreen() {
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            unselectedIcon = AppIcons.Home,
            selectedIcon = AppIconsFilled.Home,
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Chat",
            unselectedIcon = AppIcons.Chat,
            selectedIcon = AppIconsFilled.Chat,
            hasNews = false,
            badgeCount = 12
        ),
        BottomNavigationItem(
            title = "Settings",
            unselectedIcon = AppIcons.Settings,
            selectedIcon = AppIconsFilled.Settings,
            hasNews = true
        )
    )

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "My notes")
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = AppIcons.ArrowBack,
                            contentDescription = "Go back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = AppIcons.Favourite,
                            contentDescription = "Mark as favourite"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = AppIcons.Edit,
                            contentDescription = "Edit notes"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
        /*
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = AppIcons.Share,
                            contentDescription = "Share contact"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = AppIcons.Favourite,
                            contentDescription = "Mark as favourite"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = AppIcons.Mail,
                            contentDescription = "Email contact"
                        )
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = AppIcons.Call,
                            contentDescription = "Call contact"
                        )
                    }
                }
            )
        }
        */
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index, // we need to keep state
                        onClick = {
                            selectedItemIndex = index
                            //navController.navigate(item.route)
                        },
                        label = {
                            Text(text = item.title)
                        },
                        //alwaysShowLabel = false,
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.badgeCount != null) {
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    } else if (item.hasNews) {
                                        Badge()
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = if (index == selectedItemIndex)
                                        item.selectedIcon
                                    else
                                        item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            }
                        }
                    )
                }
            }
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

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    PracticeTheme {
        MainScreen()
    }
}