package org.ethan.allinone.data.reposittory

import kotlinx.coroutines.flow.Flow
import org.ethan.allinone.data.model.ProductDto
import org.ethan.allinone.data.model.ProductsResponse
import org.ethan.allinone.data.remote.RemoteDataSource
import org.ethan.allinone.presentation.state.CommonUiState
import org.ethan.allinone.presentation.state.toCommonResultFlow

class HomeRepository(private val remoteDataSource: RemoteDataSource) {
    fun getProducts(): Flow<CommonUiState<ProductsResponse>> {
        return toCommonResultFlow {
            remoteDataSource.getProducts()
        }
    }

    fun getProductDetail(id: Int?): Flow<CommonUiState<ProductDto>> {
        return toCommonResultFlow {
            remoteDataSource.getProductDetail(id);
        }
    }
}