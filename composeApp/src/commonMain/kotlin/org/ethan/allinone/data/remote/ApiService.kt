package org.ethan.allinone.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.ethan.allinone.core.utils.APIConstants
import org.ethan.allinone.data.model.ProductDto
import org.ethan.allinone.data.model.ProductsResponse

class ApiService(private val httpClient: HttpClient) {
    suspend fun getProducts(): ProductsResponse {
        return httpClient.get("${APIConstants.BASE_URL}${APIConstants.EndPoint.PRODUCT_ALL}")
            .body<ProductsResponse>()
    }

    suspend fun getProductDetails(id: Int?): ProductDto =
        httpClient.get("${APIConstants.BASE_URL}${APIConstants.EndPoint.PRODUCT_DETAIL}$id")
            .body<ProductDto>()
}