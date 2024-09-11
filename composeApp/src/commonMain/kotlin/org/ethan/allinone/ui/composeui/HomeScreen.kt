package org.ethan.allinone.ui.composeui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.ethan.allinone.data.model.ProductsResponse
import org.ethan.allinone.utils.UiState
import org.ethan.allinone.viewmodel.HomeViewModel
import org.koin.compose.getKoin

class HomeScreen(private val onLeaveHomeScreen: (Boolean) -> Unit) : Screen {

    @Composable
    override fun Content() {
        val homeViewModel: HomeViewModel = getKoin().get()
        val navigator = LocalNavigator.currentOrThrow
        onLeaveHomeScreen.invoke(false)
        Scaffold(topBar = {
            CustomToolbarScreen(navigator, title = "Home", false)
        }) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //add your code
                LaunchedEffect(key1 = Unit) {
                    getReceipesListAPI(homeViewModel)
                }
                // getReceipesListAPI(mainViewModel)
                val state = homeViewModel.uiStateProductList.collectAsState()
                when (state.value) {
                    is UiState.Success -> {
                        ProgressLoader(isLoading = false)
                        (state.value as UiState.Success<ProductsResponse>).data?.let {
                            ProductCard(it.list) { product ->
                                // Handle recipe click here
                                onLeaveHomeScreen.invoke(true)
                                navigator.push(ProductDetailScreen(homeViewModel, product.id))
                            }
                        }
                    }

                    is UiState.Loading -> {
                        ProgressLoader(isLoading = true)
                    }

                    is UiState.Error -> {
                        ProgressLoader(isLoading = false)
                        // Handle Error
                        SimpleAlertDialog(message = ((state.value as UiState.Error<ProductsResponse>).message))
                    }
                }
            }
        }
    }

}

private fun getReceipesListAPI(homeViewModel: HomeViewModel) {
    // Call the function to fetch recipes
    homeViewModel.getProductList()
}
