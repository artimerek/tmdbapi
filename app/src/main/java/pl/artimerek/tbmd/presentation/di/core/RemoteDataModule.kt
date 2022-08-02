package pl.artimerek.tbmd.presentation.di.core

import dagger.Module
import dagger.Provides
import pl.artimerek.tbmd.data.api.TMDBService
import pl.artimerek.tbmd.data.repository.artist.datasource.ArtistRemoteDatasource
import pl.artimerek.tbmd.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import pl.artimerek.tbmd.data.repository.movie.datasource.MovieRemoteDatasource
import pl.artimerek.tbmd.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import pl.artimerek.tbmd.data.repository.tvshow.datasource.TvShowRemoteDataSource
import pl.artimerek.tbmd.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService) : MovieRemoteDatasource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService) : ArtistRemoteDatasource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService) : TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }
}