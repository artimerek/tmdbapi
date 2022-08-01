package pl.artimerek.tbmd.data.repository.movie.datasource

import pl.artimerek.tbmd.data.model.movie.Movie

interface MovieLocalDatasource {

    suspend fun getMoviesFromDB() : List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()

}