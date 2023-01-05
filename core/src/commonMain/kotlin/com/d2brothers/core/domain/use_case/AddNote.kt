package com.d2brothers.core.domain.use_case

import com.d2brothers.core.data.model.Note
import com.d2brothers.core.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw Exception("The title of the note can't be empty.")
        }
        if (note.content.isBlank()) {
            throw Exception("The content of the note can't be empty.")
        }
        repository.insertNote(note)
    }
}