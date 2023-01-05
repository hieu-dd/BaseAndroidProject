package com.d2brothers.core.domain.use_case

import com.d2brothers.core.data.model.Note
import com.d2brothers.core.domain.repository.NoteRepository


data class DeleteNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        noteRepository.deleteNote(note)
    }
}