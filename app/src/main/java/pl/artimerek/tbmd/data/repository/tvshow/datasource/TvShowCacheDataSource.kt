package pl.artimerek.tbmd.data.repository.tvshow.datasource

import pl.artimerek.tbmd.data.model.tvshow.TvShow

interface TvShowCacheDataSource {

    suspend fun getTvShowsFromCache() : List<TvShow>
    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}