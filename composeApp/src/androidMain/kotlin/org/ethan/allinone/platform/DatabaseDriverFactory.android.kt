package org.ethan.allinone.platform

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.ethan.allinone.data.local.ProductDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = ProductDatabase.Schema,
            context = context,
            name = "product.db"
        )
    }
}
