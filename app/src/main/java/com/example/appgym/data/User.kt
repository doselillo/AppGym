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
    val sexU: Boolean,
    val heightU: Int,
    val weightU: Int,
    val emailU: String,
    val phoneU: Int
    )