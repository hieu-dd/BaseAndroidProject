package com.d2brothers.core.domain.data_source.database

import android.content.Context
import com.d2brothers.note.database.NoteDatabases
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(NoteDatabases.Schema, context, "note.db")
    }
}