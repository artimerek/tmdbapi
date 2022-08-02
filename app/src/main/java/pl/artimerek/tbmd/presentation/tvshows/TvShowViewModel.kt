package pl.artimerek.tbmd.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import pl.artimerek.tbmd.domain.usecase.GetTvShowsUseCase
import pl.artimerek.tbmd.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase) : ViewModel() {

    fun getTvShows() = liveData {
        val tvShows = getTvShowsUseCase.execute()
        emit(tvShows)
    }

    fun updateTvShows() = liveData {
        val tvShows = updateTvShowsUseCase.execute()
        emit(tvShows)
    }

}