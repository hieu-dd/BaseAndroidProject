package com.d2brothers.note.presentation.notes

import com.d2brothers.core.domain.model.Note
import com.d2brothers.core.domain.util.NoteOrder


sealed interface NotesEvent {
    data class Order(val noteOrder: NoteOrder) : NotesEvent
    data class DeleteNote(val note: Note) : NotesEvent
    object RestoreNote : NotesEvent
    object ToggleOrderSection : NotesEvent
}