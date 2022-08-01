package pl.artimerek.tbmd.data.repository.tvshow.datasourceimpl

import pl.artimerek.tbmd.data.api.TMDBService
import pl.artimerek.tbmd.data.model.tvshow.TvShowList
import pl.artimerek.tbmd.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey : String) : TvShowRemoteDataSource {

    override suspend fun getTvShowsFromRemote(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}