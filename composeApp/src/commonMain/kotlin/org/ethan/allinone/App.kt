package org.ethan.allinone

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.ethan.allinone.di.appModule
import org.ethan.allinone.theme.AllInOneTheme
import org.ethan.allinone.theme.AppColors
import org.ethan.allinone.ui.tabs.CartTab
import org.ethan.allinone.ui.tabs.HomeTab
import org.ethan.allinone.ui.tabs.ProfileTab
import org.ethan.allinone.ui.tabs.SupportTab
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(application = {
        modules(appModule())
    }) {
        AllInOneTheme {
            Box(
                modifier = Modifier.fillMaxSize().background(AppColors.lightBellBlue)
                    .windowInsetsPadding(WindowInsets.safeDrawing)
            ) {
                Column(
                    Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    setTabs()
                }
            }

        }
    }
}

@Composable
fun setTabs() {
    var onLeaveHomeScreen by remember { mutableStateOf(false) }
    val homeTab = HomeTab(onLeaveHomeScreen = {
        onLeaveHomeScreen = it
    })
    TabNavigator(homeTab, tabDisposable = {
        TabDisposable(
            navigator = it, tabs = listOf(homeTab, CartTab, SupportTab, ProfileTab)
        )
    }) {
        Scaffold(bottomBar = {
            AnimatedVisibility(!onLeaveHomeScreen) {
                BottomNavigation(backgroundColor = AppColors.lightBellBlue) {
                    TabNavigationItem(homeTab)
                    TabNavigationItem(CartTab)
                    TabNavigationItem(SupportTab)
                    TabNavigationItem(ProfileTab)
                }
            }
        }) { innerPadding ->
            Box(
                modifier = Modifier.padding(innerPadding)
            ) {
                CurrentTab()
            }
        }
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    val selectedTab = tabNavigator.current == tab

    BottomNavigationItem(selected = tabNavigator.current.key == tab.key,
        onClick = {
            tabNavigator.current = tab
        },
        alwaysShowLabel = true,
        label = {
            Text(
                text = tab.options.title,
                color = if (selectedTab) Color.White else Color.Gray,
                fontSize = 12.sp
            )
        },
        icon = {
            Icon(
                painter = tab.options.icon!!,
                contentDescription = tab.options.title,
                tint = if (selectedTab) Color.White else Color.Gray
            )
        })
}