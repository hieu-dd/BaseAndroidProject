package com.d2brothers.core.domain.repository

import com.d2brothers.core.data.model.Note
import com.d2brothers.core.data.model.toDomainModel
import com.d2brothers.core.domain.data_source.database.DatabaseHelper
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class LocalNoteRepositoryImpl(private val databaseHelper: DatabaseHelper) : NoteRepository {
    override fun getNotes() = databaseHelper.getAllNotes().map { it.map { it.toDomainModel() } }

    override suspend fun getNoteById(id: Long) = databaseHelper.getNoteById(id)?.toDomainModel()

    override suspend fun insertNote(note: Note) {
        databaseHelper.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        note.id?.let { databaseHelper.getNoteById(it) }
    }
}