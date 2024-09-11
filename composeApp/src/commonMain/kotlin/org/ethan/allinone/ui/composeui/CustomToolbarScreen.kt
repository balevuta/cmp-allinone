package org.ethan.allinone.ui.composeui

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.Navigator
import org.ethan.allinone.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun CustomToolbarScreen(navigator: Navigator, title: String, isBack: Boolean) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = AppColors.lightBellBlue,
            titleContentColor = MaterialTheme.colorScheme.primary,

            ),
        title = {
            Text(
                // modifier = Modifier.fillMaxWidth(),
                // textAlign = TextAlign.Center,
                text = title, color = Color.White,
                fontSize = 18.sp,
            )
        },
        modifier = Modifier.background(Color.White),
        navigationIcon = {
            if (isBack) {
                IconButton(onClick = {
                    navigator.pop()
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, "backIcon", tint = Color.White)
                }
            }
//            else {
//                IconButton(onClick = {
//                }) {
//                    Icon(Icons.Filled.Menu, "homeIcon", tint = Color.White)
//                }
//            }
        }
    )
}