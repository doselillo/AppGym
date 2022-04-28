package com.example.appgym.data

import androidx.room.Entity
import androidx.room.PrimaryKey


//data class for storing the user information from the profile fragment
@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = true)
    val idU: Int,
    val nameU: String,
    val surnameU: String,
    val dateOfBirthU: String,
    val sexU: String,
    val heightU: String,
    val weightU: String,
    val emailU: String,
    val phoneU: String
    )