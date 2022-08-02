package pl.artimerek.tbmd.presentation.di.core

import dagger.Module
import dagger.Provides
import pl.artimerek.tbmd.data.repository.artist.ArtistRepositoryImpl
import pl.artimerek.tbmd.data.repository.artist.datasource.ArtistCacheDataSource
import pl.artimerek.tbmd.data.repository.artist.datasource.ArtistLocalDatasource
import pl.artimerek.tbmd.data.repository.artist.datasource.ArtistRemoteDatasource
import pl.artimerek.tbmd.data.repository.movie.MovieRepositoryImpl
import pl.artimerek.tbmd.data.repository.movie.datasource.MovieCacheDataSource
import pl.artimerek.tbmd.data.repository.movie.datasource.MovieLocalDatasource
import pl.artimerek.tbmd.data.repository.movie.datasource.MovieRemoteDatasource
import pl.artimerek.tbmd.data.repository.tvshow.TvShowRepositoryImpl
import pl.artimerek.tbmd.data.repository.tvshow.datasource.TvShowCacheDataSource
import pl.artimerek.tbmd.data.repository.tvshow.datasource.TvShowLocalDataSource
import pl.artimerek.tbmd.data.repository.tvshow.datasource.TvShowRemoteDataSource
import pl.artimerek.tbmd.domain.repository.ArtistRepository
import pl.artimerek.tbmd.domain.repository.MovieRepository
import pl.artimerek.tbmd.domain.repository.TvShowRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDataSource: MovieCacheDataSource)  : MovieRepository {
        return MovieRepositoryImpl(movieRemoteDatasource, movieLocalDatasource, movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource)  : TvShowRepository {
        return TvShowRepositoryImpl(tvShowLocalDataSource, tvShowRemoteDataSource, tvShowCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDatasource: ArtistLocalDatasource,
        artistCacheDataSource: ArtistCacheDataSource)  : ArtistRepository {
        return ArtistRepositoryImpl(artistRemoteDatasource, artistLocalDatasource, artistCacheDataSource)
    }
}