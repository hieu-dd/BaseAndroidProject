package com.d2brothers.note.domain

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.d2brothers.core.domain.data_source.database.DatabaseDriverFactory
import com.d2brothers.note.database.NoteDatabases
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver

class TestDatabases(val context: Context) : DatabaseDriverFactory(context){
   override fun createDriver(): SqlDriver {
       return  AndroidSqliteDriver(NoteDatabases.Schema, context, null)
    }
}