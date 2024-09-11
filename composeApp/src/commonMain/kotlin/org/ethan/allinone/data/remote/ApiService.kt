package org.ethan.allinone.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.ethan.allinone.data.model.Product
import org.ethan.allinone.data.model.ProductsResponse
import org.ethan.allinone.utils.APIConstants

class ApiService(private val httpClient: HttpClient) {

    suspend fun getProducts(): ProductsResponse =
        httpClient.get("${APIConstants.BASE_URL}${APIConstants.EndPoint.PRODUCT_ALL}")
            .body<ProductsResponse>()

    suspend fun getProductDetails(id: Int?): Product =
        httpClient.get("${APIConstants.BASE_URL}${APIConstants.EndPoint.PRODUCT_DETAIL}$id")
            .body<Product>()
}