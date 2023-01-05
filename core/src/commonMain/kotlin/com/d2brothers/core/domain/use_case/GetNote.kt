package com.d2brothers.core.domain.use_case

import com.d2brothers.core.domain.model.Note
import com.d2brothers.core.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Long): Note? {
        return repository.getNoteById(id)
    }
}