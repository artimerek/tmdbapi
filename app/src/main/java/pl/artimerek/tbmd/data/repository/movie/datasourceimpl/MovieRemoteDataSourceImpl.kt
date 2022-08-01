package pl.artimerek.tbmd.data.repository.movie.datasourceimpl

import pl.artimerek.tbmd.data.api.TMDBService
import pl.artimerek.tbmd.data.model.movie.MovieList
import pl.artimerek.tbmd.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmbdService: TMDBService,
    private val apiKey:String
) : MovieRemoteDatasource {

    override suspend fun getMovies(): Response<MovieList> =tmbdService.getPopularMovies(apiKey)

}