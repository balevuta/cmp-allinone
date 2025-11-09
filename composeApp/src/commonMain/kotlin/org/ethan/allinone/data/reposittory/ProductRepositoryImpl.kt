package org.ethan.allinone.data.reposittory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.ethan.allinone.data.mapper.toDomain
import org.ethan.allinone.data.remote.RemoteDataSource
import org.ethan.allinone.domain.model.Product
import org.ethan.allinone.domain.model.ProductsResult
import org.ethan.allinone.domain.repository.ProductRepository
import org.ethan.allinone.presentation.state.CommonUiState
import org.ethan.allinone.presentation.state.toCommonResultFlow

class ProductRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : ProductRepository {
    override suspend fun getProducts(): Flow<CommonUiState<ProductsResult>> {
        return toCommonResultFlow {
            remoteDataSource.getProducts()
        }.map { uiState ->
            when (uiState) {
                is CommonUiState.Success -> {
                    val productsResult = uiState.data.toDomain()
                    CommonUiState.Success(productsResult)
                }

                is CommonUiState.Error -> {
                    CommonUiState.Error(uiState.message)
                }

                is CommonUiState.Loading -> {
                    CommonUiState.Loading
                }
            }
        }
    }

    override suspend fun getProductDetail(id: Int?): Flow<CommonUiState<Product>> {
        return toCommonResultFlow {
            remoteDataSource.getProductDetail(id)
        }.map { uiState ->
            when (uiState) {
                is CommonUiState.Success -> {
                    val product = uiState.data.toDomain()
                    CommonUiState.Success(product)
                }

                is CommonUiState.Error -> {
                    CommonUiState.Error(uiState.message)
                }

                is CommonUiState.Loading -> {
                    CommonUiState.Loading
                }
            }
        }
    }
}