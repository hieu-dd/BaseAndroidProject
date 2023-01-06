package com.d2brothers.core.data.data_source.database

import com.d2brothers.core.domain.model.Note
import com.d2brothers.note.database.NoteDatabases
import com.squareup.sqldelight.runtime.coroutines.asFlow
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.map

class DatabaseHelper(
    databaseDriverFactory: DatabaseDriverFactory,
    private val backgroundDispatcher: CoroutineDispatcher
) {
    private val database = NoteDatabases(databaseDriverFactory.createDriver())
    private val dbQuery = database.noteQueries

    fun getAllNotes() = dbQuery.getAllNotes().asFlow().map { it.executeAsList() }

    fun getNoteById(id: Long) = dbQuery.getNoteById(id).executeAsOneOrNull()

    fun insertNote(note: Note) {
        dbQuery.insertNote(note.id, note.title, note.content, note.color, note.timestamp)
    }

    fun deleteNodeById(id: Long) {
        dbQuery.deleteNoteById(id)
    }
}
