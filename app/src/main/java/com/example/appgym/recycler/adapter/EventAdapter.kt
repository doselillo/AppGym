package com.example.appgym.recycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appgym.R
import com.example.appgym.recycler.data.DataSource
import com.google.firebase.firestore.FirebaseFirestore

class EventAdapter (
    private val context: Context?
): RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    private val db = FirebaseFirestore.getInstance()
    private val eventList = DataSource.events

    class EventViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val eventImageView : ImageView? = view?.findViewById(R.id.event_imageView)
        val eventNameText : TextView? = view?.findViewById(R.id.event_textView)
        val eventDateText : TextView? = view?.findViewById(R.id.date_textView)
        val eventPlaceText : TextView? = view?.findViewById(R.id.place_textView)
        val eventLevelText : TextView? = view?.findViewById(R.id.level_textView)
        val eventContactText : TextView? = view?.findViewById(R.id.contact_textView)
        val emailText : TextView? = view?.findViewById(R.id.emailContact_textView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.event_list, parent, false)
        return EventViewHolder(adapterLayout)
    }


    override fun getItemCount() = eventList.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {

        val eventData = eventList[position]
        holder.eventImageView?.setImageResource(eventData.imageResourceId)
        holder.eventNameText?.text  =  eventData.name
        val resources = context?.resources
        holder.eventDateText?.text = resources?.getString(R.string.date_event, eventData.date)
        holder.eventPlaceText?.text = resources?.getString(R.string.place_event, eventData.place)
        holder.eventLevelText?.text = resources?.getString(R.string.level_event, eventData.level)
        holder.eventContactText?.text = resources?.getString(R.string.contact_event, eventData.contact)


        /*val email = db.collection("teachers").document(eventData.name).get().addOnSuccessListener {
            (it.get("emailT") as CharSequence?)
        }.toString()

        holder.emailText?.text = email*/



    }


}
