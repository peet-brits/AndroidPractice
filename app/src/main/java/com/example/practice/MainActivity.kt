@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)

package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
                val showBottomAppBar = false
                val windowClass = calculateWindowSizeClass(this)
                val isBigScreen = windowClass.widthSizeClass > WindowWidthSizeClass.Compact
                MainScreen(showBottomAppBar, isBigScreen = isBigScreen)
            }
        }
    }
}

data class NavigationItem(
    val title: String,
    //val route: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@Composable
private fun MainScreen(
    showBottomAppBar: Boolean,
    isBigScreen: Boolean
) {
    val items = listOf(
        NavigationItem(
            title = "Home",
            unselectedIcon = AppIcons.Home,
            selectedIcon = AppIconsFilled.Home,
            hasNews = false
        ),
        NavigationItem(
            title = "Chat",
            unselectedIcon = AppIcons.Chat,
            selectedIcon = AppIconsFilled.Chat,
            hasNews = false,
            badgeCount = 12
        ),
        NavigationItem(
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
        bottomBar = {
            if (showBottomAppBar) {
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
            } else if (!isBigScreen) {
                NavigationBar {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
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
        }
    ) { innerPadding ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (isBigScreen) {
                NavigationSideBar(
                    items = items,
                    selectedItemIndex = selectedItemIndex,
                    onNavigate = { selectedItemIndex = it }
                )
            }

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
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

@Composable
fun NavigationSideBar(
    items: List<NavigationItem>,
    selectedItemIndex: Int,
    onNavigate: (Int) -> Unit
) {
    NavigationRail(
        header = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = AppIcons.Menu,
                    contentDescription = "Menu"
                )
            }
            FloatingActionButton(
                onClick = { /*TODO*/ },
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(
                    imageVector = AppIcons.Add,
                    contentDescription = "Add"
                )
            }
        },
        modifier = Modifier
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .offset(x = (-1).dp)
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Bottom)
        ) {
            items.forEachIndexed { index, item ->
                NavigationRailItem(
                    selected = selectedItemIndex == index,
                    onClick = {
                        onNavigate(index)
                    },
                    icon = {
                        NavigationIcon(
                            item = item,
                            selected = selectedItemIndex == index
                        )
                    },
                    label = {
                        Text(text = item.title)
                    },
                )
            }
        }
    }
}

@Composable
fun NavigationIcon(
    item: NavigationItem,
    selected: Boolean
) {
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
            imageVector = if (selected) item.selectedIcon else item.unselectedIcon,
            contentDescription = item.title
        )
    }
}

@Preview(showBackground = true, name = "Compact")
@Composable
private fun MainScreenPreviewCompact() {
    PracticeTheme(darkTheme = false) {
        MainScreen(
            showBottomAppBar = false,
            isBigScreen = false
        )
    }
}

@Preview(showBackground = true, name = "Rail")
@Composable
private fun MainScreenPreviewRail() {
    PracticeTheme(darkTheme = true) {
        MainScreen(
            showBottomAppBar = false,
            isBigScreen = true
        )
    }
}

@Preview(showBackground = true, name = "Bottom App Bar")
@Composable
private fun MainScreenPreviewBottomAppBar() {
    PracticeTheme(darkTheme = true) {
        MainScreen(
            showBottomAppBar = true,
            isBigScreen = false
        )
    }
}

@Preview(showBackground = true, name = "Bottom App Bar With Rail")
@Composable
private fun MainScreenPreviewBottomAppBarRail() {
    PracticeTheme(darkTheme = true) {
        MainScreen(
            showBottomAppBar = true,
            isBigScreen = true
        )
    }
}