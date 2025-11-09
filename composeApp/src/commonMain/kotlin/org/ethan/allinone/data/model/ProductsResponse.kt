package org.ethan.allinone.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductsResponse(
    @SerialName("products")
    val products: List<ProductDto>,
    @SerialName("total")
    val total: Int = 0,
    @SerialName("skip")
    val skip: Int = 0,
    @SerialName("limit")
    val limit: Int = 0
)

@Serializable
data class ProductDto(
    @SerialName("id")
    val id: Int = 0,
    @SerialName("title")
    val title: String = "",
    @SerialName("description")
    val description: String = "",
    @SerialName("price")
    val price: Double = 0.0,
    @SerialName("discountPercentage")
    val discountPercentage: Double = 0.0,
    @SerialName("category")
    val category: String = "",
    @SerialName("thumbnail")
    val thumbnail: String = "",
    @SerialName("brand")
    val brand: String = "",
    @SerialName("stock")
    val stock: Int = 0,
    @SerialName("rating")
    val rating: Double = 0.0,
    @SerialName("images")
    val images: List<String> = emptyList()
)