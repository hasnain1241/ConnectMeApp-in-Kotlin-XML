package com.HasnainAkhtar.i221241.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.HasnainAkhtar.i221241.R
import com.HasnainAkhtar.i221241.models.People

class PeopleAdapter(private val peopleList: List<People>) : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)
        return PeopleViewHolder(view)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val person = peopleList[position]
        holder.nameTextView.text = person.name
        holder.profileImageView.setImageResource(person.imageResId)
    }

    override fun getItemCount(): Int {
        return peopleList.size
    }

    class PeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.tvName)
        val profileImageView: ImageView = itemView.findViewById(R.id.ivProfile)
    }
}
