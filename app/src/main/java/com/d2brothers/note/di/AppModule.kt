package com.d2brothers.note.di

import android.content.Context
import com.d2brothers.note.presentation.add_edit_note.AddEditNoteViewModel
import com.d2brothers.note.presentation.notes.NotesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun appModule(context: Context) = module {
    single<Context> {
        context
    }
    viewModel {
        NotesViewModel(get())
    }
    viewModel {
        AddEditNoteViewModel(get(), get())
    }
}