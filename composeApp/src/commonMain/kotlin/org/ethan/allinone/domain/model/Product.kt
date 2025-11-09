package org.ethan.allinone.domain.model

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val discountPercentage: Double,
    val category: String,
    val thumbnail: String,
    val brand: String,
    val stock: Int,
    val rating: Double,
    val images: List<String>
)

data class ProductsResult(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
