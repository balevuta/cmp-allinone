package org.ethan.allinone.data.mapper

import org.ethan.allinone.data.model.ProductDto
import org.ethan.allinone.data.model.ProductsResponse
import org.ethan.allinone.domain.model.Product
import org.ethan.allinone.domain.model.ProductsResult

fun ProductDto.toDomain(): Product {
    return Product(
        id = this.id,
        title = this.title,
        description = this.description,
        price = this.price,
        discountPercentage = this.discountPercentage,
        category = this.category,
        thumbnail = this.thumbnail,
        brand = this.brand,
        stock = this.stock,
        rating = this.rating,
        images = this.images
    )
}

fun ProductsResponse.toDomain(): ProductsResult {
    return ProductsResult(
        products = this.products.map { it.toDomain() },
        total = this.total,
        skip = this.skip,
        limit = this.limit
    )
}

