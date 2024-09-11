package org.ethan.allinone.data.reposittory

import kotlinx.coroutines.flow.Flow
import org.ethan.allinone.data.model.Product
import org.ethan.allinone.data.model.ProductsResponse
import org.ethan.allinone.data.remote.RemoteDataSource
import org.ethan.allinone.data.remote.toResultFlow
import org.ethan.allinone.utils.UiState

class HomeRepository(private val remoteDataSource: RemoteDataSource) {

    suspend fun getProducts(): Flow<UiState<ProductsResponse?>> {
        return toResultFlow {
            remoteDataSource.getProducts()
        }
    }

    suspend fun getProductDetail(id: Int?): Flow<UiState<Product?>> {
        return toResultFlow {
            remoteDataSource.getProductDetail(id)
        }
    }
}