package com.gagl.moviedbapitest.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.gagl.moviedbapitest.R
import com.gagl.moviedbapitest.databinding.TopRatedMoviesGridFragmentBinding
import com.gagl.moviedbapitest.ui.lastVisibleEvents
import com.gagl.moviedbapitest.ui.movie.viewmodel.TopRatedMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class TopRatedMoviesGridFragment: Fragment(){
    private lateinit var moviesFragmentBinding: TopRatedMoviesGridFragmentBinding
    private val topRatedMoviesViewModel : TopRatedMoviesViewModel by viewModels()
    private val moviesAdapter by lazy { MoviesAdapter(lifecycleScope) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        moviesFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.top_rated_movies_grid_fragment, container, false)

        with(moviesFragmentBinding){
            recycler.adapter = moviesAdapter
            recycler.lastVisibleEvents.onEach {
                topRatedMoviesViewModel.notifyLastVisible(it)
            }.launchIn(lifecycleScope)

            topRatedMoviesViewModel.movies.onEach {
                moviesAdapter.submitList(it)
            }.launchIn(lifecycleScope)

            topRatedMoviesViewModel.spinner.onEach {
                progress.visibility = if(it) View.VISIBLE else View.GONE
            }.launchIn(lifecycleScope)
        }
        return moviesFragmentBinding.root
    }

}