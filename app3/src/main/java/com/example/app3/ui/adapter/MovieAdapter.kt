package com.example.app3.ui.adapter

import android.arch.paging.PagedListAdapter
import android.support.v7.recyclerview.extensions.DiffCallback
import android.view.ViewGroup
import com.example.app3.model.Movie
import com.example.app3.ui.viewholder.MovieViewHolder


/**
 * Created by PVer on 2018/1/7.
 */
class MovieAdapter: PagedListAdapter<Movie, MovieViewHolder>(diffCallback)  {

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
            MovieViewHolder(parent)

    companion object {
        /**
         * @see android.support.v7.util.DiffUtil
         */
        private val diffCallback = object : DiffCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                    oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                    oldItem == newItem
        }
    }
}