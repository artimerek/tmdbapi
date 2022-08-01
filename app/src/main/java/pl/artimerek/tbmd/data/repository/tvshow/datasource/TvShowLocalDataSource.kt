package pl.artimerek.tbmd.data.repository.tvshow.datasource

import pl.artimerek.tbmd.data.model.tvshow.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShows() : List<TvShow>

    suspend fun deleteTvShows()

    suspend fun saveTvShows(tvShows : List<TvShow>)
}