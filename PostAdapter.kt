package com.HasnainAkhtar.i221241.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.HasnainAkhtar.i221241.R

import com.HasnainAkhtar.i221241.models.Post

class PostAdapter(private val postList: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postUserImage: ImageView = itemView.findViewById(R.id.postUserImage)
        val postUsername: TextView = itemView.findViewById(R.id.postUsername)
        val postImage: ImageView = itemView.findViewById(R.id.postImage)
        val postDescription: TextView = itemView.findViewById(R.id.postDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.postUserImage.setImageResource(post.userImageResId)
        holder.postUsername.text = post.username
        holder.postImage.setImageResource(post.postImageResId)
        holder.postDescription.text = post.description
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}
