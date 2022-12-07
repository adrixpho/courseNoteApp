package com.example.notesapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notesapp.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {
    @Query("SELECT * FROM notes_tbl")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM notes_tbl WHERE id = :id")
    fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateNote(note: Note)

    @Query("DELETE FROM notes_tbl")
    fun deleteAll()

    @Delete
    fun deleteNote(note: Note)
}