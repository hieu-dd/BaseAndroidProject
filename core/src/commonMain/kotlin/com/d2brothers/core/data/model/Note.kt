package com.d2brothers.core.data.model

import database.NoteEntity

data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Long,
    val id: Long? = null
)

fun NoteEntity.toDomainModel() = Note(
    id = id,
    content = content,
    title = title,
    color = color,
    timestamp = timestamp
)
