package com.HasnainAkhtar.i221241

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter(private val searchList: MutableList<String>) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private var filteredList: MutableList<String> = searchList.toMutableList()

    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSearchItem: TextView = itemView.findViewById(R.id.tvSearchItem)
        val ivDelete: ImageView = itemView.findViewById(R.id.ivDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search, parent, false)
        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val searchItem = filteredList[position]
        holder.tvSearchItem.text = searchItem
        holder.ivDelete.setOnClickListener {
            searchList.remove(searchItem)
            filter("")
        }
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    fun filter(query: String) {
        filteredList = if (query.isEmpty()) {
            searchList.toMutableList()
        } else {
            searchList.filter { it.contains(query, ignoreCase = true) }.toMutableList()
        }
        notifyDataSetChanged()
    }
}
