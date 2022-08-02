package pl.artimerek.tbmd.presentation.di.core

import dagger.Component
import pl.artimerek.tbmd.presentation.di.artist.ArtistSubComponent
import pl.artimerek.tbmd.presentation.di.movie.MovieSubComponent
import pl.artimerek.tbmd.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [
AppModule::class,
CacheDataModule::class,
DatabaseModule::class,
LocalDataModule::class,
NetModule::class,
RemoteDataModule::class,
RepositoryModule::class,
UseCaseModule::class])
interface AppComponent {

    fun movieSubComponent() : MovieSubComponent.Factory
    fun tvShowSubComponent() : TvShowSubComponent.Factory
    fun artistSubComponent() : ArtistSubComponent.Factory
}