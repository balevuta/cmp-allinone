package org.ethan.allinone.domain.repository

import kotlinx.coroutines.flow.Flow
import org.ethan.allinone.domain.model.Product
import org.ethan.allinone.domain.model.ProductsResult
import org.ethan.allinone.presentation.state.CommonUiState

interface ProductRepository {
    suspend fun getProducts(): Flow<CommonUiState<ProductsResult>>
    suspend fun getProductDetail(id: Int?): Flow<CommonUiState<Product>>
}