package com.altafrazzaque.margh.database

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class Converters {
    private val moshi = Moshi.Builder().build()
    private val listStringType = Types.newParameterizedType(List::class.java, String::class.java)
    private val adapter = moshi.adapter<List<String>>(listStringType)

    @TypeConverter
    fun fromStringList(value: String): List<String>? {
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun toStringList(value: List<String>): String {
        return adapter.toJson(value)
    }
}
