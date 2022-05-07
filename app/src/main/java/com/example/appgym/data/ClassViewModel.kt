package com.example.appgym.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.google.firebase.firestore.FirebaseFirestore

class ClassViewModel (application: Application): AndroidViewModel(application) {



    val db = FirebaseFirestore.getInstance()


}