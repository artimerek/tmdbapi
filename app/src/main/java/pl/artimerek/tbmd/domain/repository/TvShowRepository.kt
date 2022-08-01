package pl.artimerek.tbmd.domain.repository

import pl.artimerek.tbmd.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows() : List<TvShow>?

    suspend fun updateTvShows() : List<TvShow>?
}