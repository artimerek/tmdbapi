package pl.artimerek.tbmd.domain.usecase

import pl.artimerek.tbmd.data.model.tvshow.TvShow
import pl.artimerek.tbmd.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute() : List<TvShow>? = tvShowRepository.updateTvShows()
}