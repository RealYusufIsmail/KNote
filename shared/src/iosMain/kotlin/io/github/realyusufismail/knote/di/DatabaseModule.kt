package io.github.realyusufismail.knote.di

import io.github.realyusufismail.knote.data.local.DatabaseDriverFactory
import io.github.realyusufismail.knote.domain.note.NoteDataSource
import io.github.realyusufismail.database.NoteDatabase
import io.github.realyusufismail.knote.data.note.SqlDelightNoteDataSource
class DatabaseModule {

    private val factory by lazy { DatabaseDriverFactory() }
    val noteDataSource: NoteDataSource by lazy {
        SqlDelightNoteDataSource(NoteDatabase(factory.createDriver()))
    }
}