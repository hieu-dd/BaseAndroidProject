package com.d2brothers.core.domain.repository

import com.d2brothers.core.data.model.Note
import com.d2brothers.core.data.model.toDomainModel
import com.d2brothers.core.domain.data_source.database.DatabaseHelper
import kotlinx.coroutines.flow.flow

class LocalNoteRepositoryImpl(private val databaseHelper: DatabaseHelper) : NoteRepository {
    override fun getNotes() = flow {
        emit(databaseHelper.getAllNotes().map { it.toDomainModel() })
    }


    override suspend fun getNoteById(id: Long) = databaseHelper.getNoteById(id)?.toDomainModel()

    override suspend fun insertNote(note: Note) {
        databaseHelper.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        note.id?.let { databaseHelper.getNoteById(it) }
    }
}