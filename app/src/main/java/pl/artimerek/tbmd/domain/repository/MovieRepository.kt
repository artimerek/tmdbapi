package pl.artimerek.tbmd.domain.repository

import pl.artimerek.tbmd.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies() : List<Movie>?

    suspend fun updateMovies() : List<Movie>?
}