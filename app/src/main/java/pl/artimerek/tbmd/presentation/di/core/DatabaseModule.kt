package pl.artimerek.tbmd.presentation.di.core

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import pl.artimerek.tbmd.data.db.ArtistDao
import pl.artimerek.tbmd.data.db.MovieDao
import pl.artimerek.tbmd.data.db.TMDBDatabase
import pl.artimerek.tbmd.data.db.TvShowDao
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context) : TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase) : MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase) : ArtistDao {
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTvDao(tmdbDatabase: TMDBDatabase) : TvShowDao {
        return tmdbDatabase.tvDao()
    }
}