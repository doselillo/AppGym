package com.example.appgym.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teacher_table")
data class Teacher (
    @PrimaryKey(autoGenerate = true)
    val idT: Int,
    val nameT: String,
    val surnameT: String,
    val emailT: String
)
