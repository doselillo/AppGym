package com.example.appgym.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "classes_table")
data class Classes (
    @PrimaryKey(autoGenerate = true)
    val idC: Int,
    val nameC: String,
    val maximumReservationsC: Int,
    val reservationsC: Int
)

