package pl.artimerek.tbmd.domain.usecase

import pl.artimerek.tbmd.data.model.movie.Movie
import pl.artimerek.tbmd.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute() : List<Movie>? = movieRepository.updateMovies()
}