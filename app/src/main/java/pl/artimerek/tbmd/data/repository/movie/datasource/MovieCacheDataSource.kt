package pl.artimerek.tbmd.data.repository.movie.datasource

import pl.artimerek.tbmd.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache() : List<Movie>
    suspend fun saveMoviesToCache(movies : List<Movie>)
}