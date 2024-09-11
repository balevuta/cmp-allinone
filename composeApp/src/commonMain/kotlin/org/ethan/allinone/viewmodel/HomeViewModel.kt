package org.ethan.allinone.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.ethan.allinone.data.model.Product
import org.ethan.allinone.data.model.ProductsResponse
import org.ethan.allinone.data.reposittory.HomeRepository
import org.ethan.allinone.utils.UiState

class HomeViewModel(private val homeRepository: HomeRepository) : BaseViewModel() {

    val _uiStateProductList = MutableStateFlow<UiState<ProductsResponse?>>(UiState.Loading)
    val uiStateProductList: StateFlow<UiState<ProductsResponse?>> = _uiStateProductList

    val _uiStateProductDetail = MutableStateFlow<UiState<Product?>>(UiState.Loading)
    val uiStateProductDetail: StateFlow<UiState<Product?>> = _uiStateProductDetail

    fun getProductList() = CoroutineScope(Dispatchers.IO).launch {
        fetchData(_uiStateProductList) { homeRepository.getProducts() }
    }

    fun getProductDetail(id: Int?) = CoroutineScope(Dispatchers.IO).launch {
        fetchData(_uiStateProductDetail) { homeRepository.getProductDetail(id) }
    }
}