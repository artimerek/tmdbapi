package pl.artimerek.tbmd.data.repository.movie

import android.util.Log
import pl.artimerek.tbmd.data.model.movie.Movie
import pl.artimerek.tbmd.data.repository.movie.datasource.MovieCacheDataSource
import pl.artimerek.tbmd.data.repository.movie.datasource.MovieLocalDatasource
import pl.artimerek.tbmd.data.repository.movie.datasource.MovieRemoteDatasource
import pl.artimerek.tbmd.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDatasource: MovieLocalDatasource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDatasource.clearAll()
        movieLocalDatasource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromAPI() : List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDatasource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (exception : Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return movieList
    }

    private suspend fun getMoviesFromDB() : List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDatasource.getMoviesFromDB()
        } catch (exception : Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDatasource.saveMoviesToDB(movieList)
        }

        return movieList
    }

    private suspend fun getMoviesFromCache() : List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception : Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}