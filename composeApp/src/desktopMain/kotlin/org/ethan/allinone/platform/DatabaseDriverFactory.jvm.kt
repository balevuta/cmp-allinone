package org.ethan.allinone.platform

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.sqlite.JvmSqliteDriver
import org.ethan.allinone.data.local.ProductDatabase
import java.io.File

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        val dbFile = File(System.getProperty("java.io.tmpdir"), "product.db")
        return JvmSqliteDriver(
            schema = ProductDatabase.Schema,
            url = "jdbc:sqlite:${dbFile.absolutePath}"
        )
    }
}

