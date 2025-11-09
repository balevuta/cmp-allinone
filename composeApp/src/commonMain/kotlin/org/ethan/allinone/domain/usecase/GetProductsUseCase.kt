package org.ethan.allinone.domain.usecase

import kotlinx.coroutines.flow.Flow
import org.ethan.allinone.domain.model.ProductsResult
import org.ethan.allinone.domain.repository.ProductRepository
import org.ethan.allinone.presentation.state.CommonUiState

class GetProductsUseCase(
    private val productRepository: ProductRepository
) {
    suspend fun execute(): Flow<CommonUiState<ProductsResult>> {
        return productRepository.getProducts()
    }
}
