package pl.artimerek.tbmd.data.repository.movie.datasourceimpl

import pl.artimerek.tbmd.data.model.movie.Movie
import pl.artimerek.tbmd.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {

    private var movieList =  ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}