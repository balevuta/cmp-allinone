package org.ethan.allinone.data.local

import kotlinx.serialization.json.Json
import org.ethan.allinone.data.model.ProductDto
import org.ethan.allinone.data.model.ProductsResponse

class LocalDataSource(
    private val productDatabase: ProductDatabase
) {
    suspend fun getAllProducts(): List<ProductDto> {
        return productDatabase.productDatabaseQueries
            .getAllProducts()
            .executeAsList()
            .map { productEntity ->
                productEntity.toDto()
            }
    }

    suspend fun getProductById(id: Int): ProductDto? {
        return productDatabase.productDatabaseQueries
            .getProductById(id.toLong())
            .executeAsOneOrNull()
            ?.toDto()
    }

    suspend fun insertProducts(products: List<ProductDto>) {
        productDatabase.productDatabaseQueries.transaction {
            products.forEach { product ->
                insertProductSync(product)
            }
        }
    }

    suspend fun insertProduct(product: ProductDto) {
        productDatabase.productDatabaseQueries.insertProduct(
            id = product.id.toLong(),
            title = product.title,
            description = product.description,
            price = product.price,
            discount_percentage = product.discountPercentage,
            category = product.category,
            thumbnail = product.thumbnail,
            brand = product.brand,
            stock = product.stock.toLong(),
            rating = product.rating,
            images = Json.encodeToString(product.images)
        )
    }

    private fun insertProductSync(product: ProductDto) {
        productDatabase.productDatabaseQueries.insertProduct(
            id = product.id.toLong(),
            title = product.title,
            description = product.description,
            price = product.price,
            discount_percentage = product.discountPercentage,
            category = product.category,
            thumbnail = product.thumbnail,
            brand = product.brand,
            stock = product.stock.toLong(),
            rating = product.rating,
            images = Json.encodeToString(product.images)
        )
    }

    suspend fun deleteAllProducts() {
        productDatabase.productDatabaseQueries.deleteAllProducts()
    }

    suspend fun deleteProductById(id: Int) {
        productDatabase.productDatabaseQueries.deleteProductById(id.toLong())
    }

    suspend fun saveProductsResponse(productsResponse: ProductsResponse) {
        deleteAllProducts()
        insertProducts(productsResponse.products)
    }

    private fun Product.toDto(): ProductDto {
        return ProductDto(
            id = this.id.toInt(),
            title = this.title,
            description = this.description,
            price = this.price,
            discountPercentage = this.discount_percentage,
            category = this.category,
            thumbnail = this.thumbnail,
            brand = this.brand,
            stock = this.stock.toInt(),
            rating = this.rating,
            images = try {
                Json.decodeFromString<List<String>>(this.images)
            } catch (e: Exception) {
                emptyList()
            }
        )
    }
}

