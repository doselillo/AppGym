package com.example.appgym.recycler.model

import androidx.annotation.DrawableRes

data class Event (

        @DrawableRes val imageResourceId: Int,
        val name: String,
        val date: String,
        val place: String,
        val level: String,
        val contact: String,
        val emailT: String


)