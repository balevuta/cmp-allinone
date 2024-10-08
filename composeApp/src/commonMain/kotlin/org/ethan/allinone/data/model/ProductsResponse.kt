package org.ethan.allinone.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductsResponse(
    @SerialName("products")
    var list: List<Product>
)

@Serializable
data class Product(
    @SerialName("id")
    var id: Int = 0,
    @SerialName("title")
    var title: String = "",
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
    val images: List<String>? = null,
    var isFavourite: Boolean? = false,
    var isAddtoCart: Boolean? = false,
    var quantity: Int? = 0,
)