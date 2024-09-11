package org.ethan.allinone.ui.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.ethan.allinone.ui.composeui.SupportScreen

object SupportTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Phone)
            return remember {
                TabOptions(index = 0u, title = "Support", icon = icon)
            }
        }

    @Composable
    override fun Content() {
        TabContent(SupportScreen)
    }
}