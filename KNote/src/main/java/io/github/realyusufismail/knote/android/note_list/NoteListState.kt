package io.github.realyusufismail.knote.android.note_list

import io.github.realyusufismail.knote.domain.note.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchText: String = "",
    val isSearchActive: Boolean = false
)
