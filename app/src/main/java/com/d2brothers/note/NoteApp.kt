package com.d2brothers.note

import android.app.Application
import android.content.Context
import com.d2brothers.core.initKoin
import com.d2brothers.note.di.appModule
import org.koin.dsl.module

class NoteApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(
            appModule(this@NoteApp),
        )
    }
}