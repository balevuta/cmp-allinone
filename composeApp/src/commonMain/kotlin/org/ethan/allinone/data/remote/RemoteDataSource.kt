package org.ethan.allinone.data.remote

import org.ethan.allinone.data.model.ProductsResponse

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getProducts(): ProductsResponse = apiService.getProducts()
    suspend fun getProductDetail(id: Int?) = apiService.getProductDetails(id)
}