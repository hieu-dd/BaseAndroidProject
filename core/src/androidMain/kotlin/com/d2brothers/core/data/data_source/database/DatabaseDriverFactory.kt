package com.d2brothers.core.data.data_source.database

import android.content.Context
import com.d2brothers.note.database.NoteDatabases
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual open class DatabaseDriverFactory(
    private val context: Context,
    private val dbName: String? = "note.db"
) {
    actual open fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(NoteDatabases.Schema, context, dbName)
    }
}