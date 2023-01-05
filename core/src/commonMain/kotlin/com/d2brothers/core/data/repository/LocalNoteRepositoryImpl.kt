package com.d2brothers.core.data.repository

import com.d2brothers.core.domain.model.Note
import com.d2brothers.core.domain.model.toDomainModel
import com.d2brothers.core.data.data_source.database.DatabaseHelper
import com.d2brothers.core.domain.repository.NoteRepository
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