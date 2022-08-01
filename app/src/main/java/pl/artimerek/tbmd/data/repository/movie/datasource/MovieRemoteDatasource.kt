package pl.artimerek.tbmd.data.repository.movie.datasource

import pl.artimerek.tbmd.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {

    suspend fun getMovies() : Response<MovieList>
}