package org.ethan.allinone.data.reposittory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.ethan.allinone.data.local.LocalDataSource
import org.ethan.allinone.data.mapper.toDomain
import org.ethan.allinone.data.model.ProductsResponse
import org.ethan.allinone.data.remote.RemoteDataSource
import org.ethan.allinone.domain.model.Product
import org.ethan.allinone.domain.model.ProductsResult
import org.ethan.allinone.domain.repository.ProductRepository
import org.ethan.allinone.presentation.state.CommonUiState

class ProductRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : ProductRepository {
    override suspend fun getProducts(): Flow<CommonUiState<ProductsResult>> {
        return flow {
            emit(CommonUiState.Loading)
            try {
                val localProducts = localDataSource.getAllProducts()
                if (localProducts.isNotEmpty()) {
                    val localProductsResponse = ProductsResponse(
                        products = localProducts,
                        total = localProducts.size,
                        skip = 0,
                        limit = localProducts.size
                    )
                    val productsResult = localProductsResponse.toDomain()
                    emit(CommonUiState.Success(productsResult))
                }
                val remoteResponse = remoteDataSource.getProducts()
                localDataSource.saveProductsResponse(remoteResponse)
                val productsResult = remoteResponse.toDomain()
                emit(CommonUiState.Success(productsResult))
            } catch (e: Exception) {
                val localProducts = localDataSource.getAllProducts()
                if (localProducts.isNotEmpty()) {
                    val localProductsResponse = ProductsResponse(
                        products = localProducts,
                        total = localProducts.size,
                        skip = 0,
                        limit = localProducts.size
                    )
                    val productsResult = localProductsResponse.toDomain()
                    emit(CommonUiState.Success(productsResult))
                } else {
                    emit(CommonUiState.Error<ProductsResult>(e.message ?: "Unknown error"))
                }
            }
        }
    }

    override suspend fun getProductDetail(id: Int?): Flow<CommonUiState<Product>> {
        return flow {
            emit(CommonUiState.Loading)
            try {
                if (id != null) {
                    val localProduct = localDataSource.getProductById(id)
                    if (localProduct != null) {
                        val product = localProduct.toDomain()
                        emit(CommonUiState.Success(product))
                    }
                    val remoteProduct = remoteDataSource.getProductDetail(id)
                    if (localProduct == null || localProduct.id != remoteProduct.id) {
                        localDataSource.insertProduct(remoteProduct)
                    }
                    val product = remoteProduct.toDomain()
                    emit(CommonUiState.Success(product))
                } else {
                    emit(CommonUiState.Error<Product>("Product ID is null"))
                }
            } catch (e: Exception) {
                if (id != null) {
                    val localProduct = localDataSource.getProductById(id)
                    if (localProduct != null) {
                        val product = localProduct.toDomain()
                        emit(CommonUiState.Success(product))
                    } else {
                        emit(CommonUiState.Error<Product>(e.message ?: "Unknown error"))
                    }
                } else {
                    emit(CommonUiState.Error<Product>(e.message ?: "Unknown error"))
                }
            }
        }
    }
}