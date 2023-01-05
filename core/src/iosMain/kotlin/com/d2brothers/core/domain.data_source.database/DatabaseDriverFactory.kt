package com.d2brothers.core.domain.data_source.database

import com.d2brothers.note.database.NoteDatabases
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual open class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(NoteDatabases.Schema, "note.db")
    }
}