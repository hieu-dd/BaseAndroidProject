package com.d2brothers.core.data.data_source.database

import com.squareup.sqldelight.db.SqlDriver

expect open class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}