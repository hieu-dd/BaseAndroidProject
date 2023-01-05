package com.d2brothers.note

import android.app.Application
import androidx.test.platform.app.InstrumentationRegistry
import com.d2brothers.core.domain.data_source.database.DatabaseDriverFactory
import com.d2brothers.core.initKoin
import com.d2brothers.note.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

class TestApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(
            appModule(this@TestApplication),
            platform = module {
                single {
                    DatabaseDriverFactory(get(), null)
                }
            }
        ).apply {
            androidContext(InstrumentationRegistry.getInstrumentation().targetContext.applicationContext)
        }
    }
}