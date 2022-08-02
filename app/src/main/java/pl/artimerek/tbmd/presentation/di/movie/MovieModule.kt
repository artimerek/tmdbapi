package pl.artimerek.tbmd.presentation.di.movie

import dagger.Module
import dagger.Provides
import pl.artimerek.tbmd.domain.usecase.GetMoviesUseCase
import pl.artimerek.tbmd.domain.usecase.UpdateMoviesUseCase
import pl.artimerek.tbmd.presentation.movie.MovieViewModelFactory

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ) : MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}