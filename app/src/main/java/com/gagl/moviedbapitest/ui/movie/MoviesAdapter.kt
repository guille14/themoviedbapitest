package com.gagl.moviedbapitest.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gagl.moviedbapitest.R
import com.gagl.moviedbapitest.data.domain.Movie
import com.gagl.moviedbapitest.databinding.ViewMovieBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class MoviesAdapter(private val scope: CoroutineScope) :
    ListAdapter<Movie, MoviesAdapter.ItemViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = with(holder) {
        val item = getItem(position)
        bind(item)
//        scope.collectFlow(itemView.onClickEvents) {
//            itemView.context.toast(item.title)
//        }
        return@with
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ViewMovieBinding.bind(itemView)
        fun bind(item: Movie) = with(binding) {
            movieTitle.text = item.title
            Glide
                .with(movieCover.context)
                .load("https://image.tmdb.org/t/p/w500/${item.posterPath}")
                .into(movieCover)
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}