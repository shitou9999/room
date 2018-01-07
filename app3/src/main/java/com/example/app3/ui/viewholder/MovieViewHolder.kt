package com.example.app3.ui.viewholder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.app3.R
import com.example.app3.model.Movie

/**
 * Created by PVer on 2018/1/7.
 */
class MovieViewHolder(val parent: ViewGroup):RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(layout.item_movie, parent, false)) {

            private val picture: ImageView = itemView.findViewById(R.id.picture)
            private val title: TextView = itemView.findViewById(R.id.title)
            private val ratingBar: RatingBar = itemView.findViewById(R.id.rating_bar)
            private val ratingDes: TextView = itemView.findViewById(R.id.rating_des)
            private val textView: TextView = itemView.findViewById(R.id.textView)
            private val director: TextView = itemView.findViewById(R.id.director)
            private val actors: TextView = itemView.findViewById(R.id.actors)
            private val type: TextView = itemView.findViewById(R.id.type)
            private val year: TextView = itemView.findViewById(R.id.year)


            fun bindTo(data: Movie?) {
                data ?: return
                title.text = data.title
                director.text = data.director
                ratingBar.rating = data.rating ?: 0.0f
                ratingDes.text = data.ratingStr
                actors.text = data.casts
                Glide.with(parent.context).load(data.avatar).into(picture)
                type.text = data.genres
                year.text = data.year
            }

}

