package com.example.notesapp.utils

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

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