package com.example.harajtask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.harajtask.data.Post


class PostsListAdapter(val onClick:(Post) -> Unit): ListAdapter<Post, PostsListAdapter.PostViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.post_item,parent,false)
        return PostViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PostViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {


        /**
         * setting data through data binding distorts the layout and I kept it this way
         */
        private val image: ImageView = itemView.findViewById(R.id.imageView)
        private val title: TextView = itemView.findViewById(R.id.titleText)
        private val dateText: TextView = itemView.findViewById(R.id.dateText)
        private val commentText: TextView = itemView.findViewById(R.id.commentText)
        private val usernameText: TextView = itemView.findViewById(R.id.usernameText)
        fun bind(post: Post) {
                title.text = post.title
                Glide.with(itemView)
                    .load(post.thumbURL)
                    .centerCrop()
                    .into(image)
                bindDate(dateText,post.date)
                usernameText.text = post.username
                post.commentCount?.let {
                    if (it> 0) commentText.text = it.toString()
                    else commentText.visibility = View.INVISIBLE
                }
            itemView.setOnClickListener {
                onClick(post)
            }




        }


    }



}

val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Post>() {
    override fun areContentsTheSame(oldItem: Post, newItem: Post) = oldItem == newItem

    override fun areItemsTheSame(oldItem: Post, newItem: Post) = oldItem.title == newItem.title

}

