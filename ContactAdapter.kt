package com.HasnainAkhtar.i221241.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.HasnainAkhtar.i221241.R
import com.HasnainAkhtar.i221241.models.Contact


class ContactAdapter(private val contactList: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.ivProfileImage)
        val contactName: TextView = itemView.findViewById(R.id.tvContactName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contactList[position]
        holder.profileImage.setImageResource(contact.profileImageResId)
        holder.contactName.text = contact.name

        if (contact.isBold) {
            holder.contactName.setTypeface(null, android.graphics.Typeface.BOLD)
        } else {
            holder.contactName.setTypeface(null, android.graphics.Typeface.NORMAL)
        }




    }

    override fun getItemCount(): Int = contactList.size
}
