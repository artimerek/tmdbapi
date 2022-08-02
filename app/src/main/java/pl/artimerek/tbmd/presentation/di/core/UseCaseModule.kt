package pl.artimerek.tbmd.presentation.di.core

import dagger.Module
import dagger.Provides
import pl.artimerek.tbmd.domain.repository.ArtistRepository
import pl.artimerek.tbmd.domain.repository.MovieRepository
import pl.artimerek.tbmd.domain.repository.TvShowRepository
import pl.artimerek.tbmd.domain.usecase.*

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository) : GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository) : UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository) : UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository) : GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }


    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository) : GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository) : UpdateArtistUseCase {
        return UpdateArtistUseCase(artistRepository)
    }

}