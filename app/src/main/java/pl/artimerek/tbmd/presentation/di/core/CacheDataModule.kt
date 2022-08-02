package pl.artimerek.tbmd.presentation.di.core

import dagger.Module
import dagger.Provides
import pl.artimerek.tbmd.data.repository.artist.datasource.ArtistCacheDataSource
import pl.artimerek.tbmd.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import pl.artimerek.tbmd.data.repository.movie.datasource.MovieCacheDataSource
import pl.artimerek.tbmd.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import pl.artimerek.tbmd.data.repository.tvshow.datasource.TvShowCacheDataSource
import pl.artimerek.tbmd.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource() : MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource() : TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource() : ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}