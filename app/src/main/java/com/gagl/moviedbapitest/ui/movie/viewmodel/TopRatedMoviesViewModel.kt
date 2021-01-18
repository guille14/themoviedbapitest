package com.gagl.moviedbapitest.ui.movie.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gagl.moviedbapitest.data.domain.Movie
import com.gagl.moviedbapitest.data.domain.MoviesRepository
import com.gagl.moviedbapitest.data.domain.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class TopRatedMoviesViewModel @ViewModelInject constructor(private val moviesRepository: MoviesRepository): ViewModel() {
    private val _spinner = MutableStateFlow(true)
    val spinner: StateFlow<Boolean> get() = _spinner
    val movies: Flow<List<Movie>> get() = moviesRepository.getTopRatedMovies()

    init {
        viewModelScope.launch { notifyLastVisible(0) }
    }

    suspend fun notifyLastVisible(lastVisible: Int) {
        moviesRepository.checkTopRatedNewPageRequired(lastVisible)
        _spinner.value = false
    }
}