package com.d2brothers.core.domain.data_source.database

import com.d2brothers.core.data.model.Note
import com.d2brothers.note.database.NoteDatabases
import kotlinx.coroutines.CoroutineDispatcher

class DatabaseHelper(
    databaseDriverFactory: DatabaseDriverFactory,
    private val backgroundDispatcher: CoroutineDispatcher
) {
    private val database = NoteDatabases(databaseDriverFactory.createDriver())
    private val dbQuery = database.noteQueries

    fun getAllNotes() = dbQuery.getAllNotes().executeAsList()

    fun getNoteById(id: Long) = dbQuery.getNoteById(id).executeAsOneOrNull()

    fun insertNote(note: Note) {
        dbQuery.insertNote(note.title, note.content, note.color,note.timestamp)
    }
}