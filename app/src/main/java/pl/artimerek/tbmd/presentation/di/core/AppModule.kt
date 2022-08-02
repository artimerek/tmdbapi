package pl.artimerek.tbmd.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.artimerek.tbmd.presentation.di.artist.ArtistSubComponent
import pl.artimerek.tbmd.presentation.di.movie.MovieSubComponent
import pl.artimerek.tbmd.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, TvShowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext() : Context {
        return context.applicationContext
    }
}