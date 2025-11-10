package org.ethan.allinone.platform

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import org.ethan.allinone.data.local.ProductDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            schema = ProductDatabase.Schema,
            name = "product.db"
        )
    }
}

