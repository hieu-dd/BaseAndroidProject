package com.d2brothers.core

import com.d2brothers.core.domain.data_source.database.DatabaseHelper
import com.d2brothers.core.domain.repository.LocalNoteRepositoryImpl
import com.d2brothers.core.domain.use_case.AddNote
import com.d2brothers.core.domain.use_case.DeleteNote
import com.d2brothers.core.domain.use_case.GetNote
import com.d2brothers.core.domain.use_case.GetNotes
import com.d2brothers.core.domain.use_case.NoteUseCases
import kotlinx.coroutines.Dispatchers
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

fun initKoin(appModule: Module, platform: Module = platformModule): KoinApplication {
    val koinApplication = startKoin {
        modules(
            appModule,
            platform,
            coreModule,
        )
    }
    return koinApplication
}

val coreModule = module {
    single {
        DatabaseHelper(
            get(),
            Dispatchers.Default
        )
    }
    single {
        LocalNoteRepositoryImpl(get())
    }
    single {
        NoteUseCases(
            getNotes = GetNotes(get<LocalNoteRepositoryImpl>()),
            deleteNote = DeleteNote(get<LocalNoteRepositoryImpl>()),
            getNote = GetNote(get<LocalNoteRepositoryImpl>()),
            addNote = AddNote(get<LocalNoteRepositoryImpl>())
        )
    }
}

expect val platformModule: Module