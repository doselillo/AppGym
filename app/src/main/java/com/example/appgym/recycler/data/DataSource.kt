package com.example.appgym.recycler.data

import com.example.appgym.R
import com.example.appgym.recycler.model.Event
import com.google.firebase.firestore.FirebaseFirestore

object DataSource {

    private val db = FirebaseFirestore.getInstance()


    val events: List<Event> = listOf(
        Event(
            R.drawable.bike,
            "BIKE RACE 2022",
            "23/08/2022",
            "LONDON",
            "MEDIUM",
            "JACK RUSSELL",
            ""

        ),
        Event(
            R.drawable.boxing,
            "LIGHTWEIGHT BOXING TOURNAMENT",
            "12/09/2022",
            "MANCHESTER",
            "HIGH",
            "JIMMY THOMPSON",
            ""
        ),
        Event(
            R.drawable.hiking,
            "NATURE HIKE",
            "20/09/2022",
            "LOWLANDS PARK",
            "LOW",
            "MADDIE JACKSON",
            ""
        ),
        Event(
            R.drawable.race,
            "YORK HALF MARATHON",
            "04/10/2022",
            "YORK",
            "HIGH",
            "MARK STOM",
            ""
        ),
        Event(
            R.drawable.swimming,
            "SWIMMING LESSONS FOR CHILDREN",
            "29/09/2022",
            "LONDON",
            "LOW",
            "JACK RUSSELL",
            ""
        ),
        Event(
            R.drawable.tennis,
            "TENNIS AMATEUR TOURNAMENT",
            "01/07/2022",
            "LONDON",
            "LOW",
            "BORT VAN HOUTEN",
            ""
        )




    )

    /*private fun getData(name: String): String {
        db.collection("teachers").document(name).get().addOnSuccessListener {
           val names = (it.get("nameT") as String?) + (it.get("surnameT") as String?)
        }
        return
    }*/

}