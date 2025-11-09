package org.ethan.allinone.presentation.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.ethan.allinone.data.model.ProductDto
import org.ethan.allinone.data.model.ProductsResponse
import org.ethan.allinone.data.reposittory.HomeRepository
import org.ethan.allinone.presentation.state.CommonUiState

class HomeViewModel(private val homeRepository: HomeRepository) : BaseViewModel() {

    private val _uiStateProductList = MutableStateFlow<CommonUiState<ProductsResponse?>>(CommonUiState.Loading)
    val uiStateProductList: StateFlow<CommonUiState<ProductsResponse?>> = _uiStateProductList

    private val _uiStateProductDetail = MutableStateFlow<CommonUiState<ProductDto?>>(CommonUiState.Loading)
    val uiStateProductDetail: StateFlow<CommonUiState<ProductDto?>> = _uiStateProductDetail

    fun getProductList() = CoroutineScope(Dispatchers.IO).launch {
        fetchData(_uiStateProductList) { homeRepository.getProducts() }
    }

    fun getProductDetail(id: Int?) = CoroutineScope(Dispatchers.IO).launch {
        fetchData(_uiStateProductDetail) { homeRepository.getProductDetail(id) }
    }
}