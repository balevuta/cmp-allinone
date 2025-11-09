package org.ethan.allinone.presentation.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.ethan.allinone.domain.model.ProductsResult
import org.ethan.allinone.domain.usecase.GetProductsUseCase
import org.ethan.allinone.platform.getPlatform
import org.ethan.allinone.presentation.state.CommonUiState

class ProductsViewModel(
    private val getProductsUseCase: GetProductsUseCase
) : BaseViewModel() {
    private val _uiStateProducts = MutableStateFlow<CommonUiState<ProductsResult>>(CommonUiState.Loading)
    val uiStateProducts: StateFlow<CommonUiState<ProductsResult>> = _uiStateProducts

    fun loadProducts() {
        CoroutineScope(getPlatform().coroutineDispatcher).launch {
            fetchData(_uiStateProducts) { getProductsUseCase.execute() }
        }
    }
}