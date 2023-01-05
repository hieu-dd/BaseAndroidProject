package com.d2brothers.note

import android.app.Application
import androidx.test.platform.app.InstrumentationRegistry
import com.d2brothers.core.coreModule
import com.d2brothers.core.initKoin
import com.d2brothers.core.platformModule
import com.d2brothers.note.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(
            appModule(this@TestApplication),
        ).apply {
            androidContext(InstrumentationRegistry.getInstrumentation().targetContext.applicationContext)
        }
    }
}