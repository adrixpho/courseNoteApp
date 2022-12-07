package com.example.notesapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.Date
import java.util.Locale
import java.util.UUID

fun formatDate(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat(
        "EEE, d MMM hh:mm aaa",
        Locale.getDefault(),
    )
    return format.format(date)
}

class DateConverter {
    @TypeConverter
    fun timeStampFromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun dateFromTimestamp(timestamp: Long): Date? {
        return Date(timestamp)
    }
}

@Entity(tableName = "notes_tbl")
data class Note(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "note_title") val title: String,
    @ColumnInfo(name = "note_description") val description: String,
    @ColumnInfo(name = "note_entry_date") val entryDate: Date = Date.from(Instant.now())
)
