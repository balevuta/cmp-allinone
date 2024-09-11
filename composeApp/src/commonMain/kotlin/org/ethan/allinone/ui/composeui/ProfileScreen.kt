package org.ethan.allinone.ui.composeui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.ethan.allinone.theme.AppColors
import org.ethan.allinone.viewmodel.HomeViewModel
import org.koin.compose.getKoin

object ProfileScreen : Screen {

    @Composable
    override fun Content() {
        val homeViewModel: HomeViewModel = getKoin().get()
        val navigator = LocalNavigator.currentOrThrow
        Scaffold(topBar = {
            CustomToolbarScreen(navigator, title = "My Bell", false)
        })
        { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding).padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //add your code
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "You are not logging in your Bell account. Please login to access your Bell services!",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(containerColor = AppColors.lightBellBlue)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "LOGIN",
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }

}