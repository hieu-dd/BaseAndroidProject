package com.d2brothers.core

import com.d2brothers.core.data.data_source.database.DatabaseDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {

    single {
        DatabaseDriverFactory(get())
    }
}