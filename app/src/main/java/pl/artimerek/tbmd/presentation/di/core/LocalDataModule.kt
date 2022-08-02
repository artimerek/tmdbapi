package pl.artimerek.tbmd.presentation.di.core

import dagger.Module
import dagger.Provides
import pl.artimerek.tbmd.data.db.ArtistDao
import pl.artimerek.tbmd.data.db.MovieDao
import pl.artimerek.tbmd.data.db.TvShowDao
import pl.artimerek.tbmd.data.repository.artist.datasource.ArtistLocalDatasource
import pl.artimerek.tbmd.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import pl.artimerek.tbmd.data.repository.movie.datasource.MovieLocalDatasource
import pl.artimerek.tbmd.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import pl.artimerek.tbmd.data.repository.tvshow.datasource.TvShowLocalDataSource
import pl.artimerek.tbmd.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieDao(movieDao: MovieDao) : MovieLocalDatasource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistDao(artistDao: ArtistDao) : ArtistLocalDatasource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tvShowDao: TvShowDao) : TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
}