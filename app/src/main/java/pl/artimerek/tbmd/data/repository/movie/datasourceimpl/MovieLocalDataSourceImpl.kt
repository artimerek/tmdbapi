package pl.artimerek.tbmd.data.repository.movie.datasourceimpl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.artimerek.tbmd.data.db.MovieDao
import pl.artimerek.tbmd.data.model.movie.Movie
import pl.artimerek.tbmd.data.repository.movie.datasource.MovieLocalDatasource

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDatasource {

    override suspend fun getMoviesFromDB(): List<Movie> = movieDao.getMovies()

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}