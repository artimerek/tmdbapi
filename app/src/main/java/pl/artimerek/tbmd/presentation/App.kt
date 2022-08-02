package pl.artimerek.tbmd.presentation

import android.app.Application
import pl.artimerek.tbmd.BuildConfig
import pl.artimerek.tbmd.presentation.di.Injector
import pl.artimerek.tbmd.presentation.di.artist.ArtistSubComponent
import pl.artimerek.tbmd.presentation.di.core.*
import pl.artimerek.tbmd.presentation.di.movie.MovieSubComponent
import pl.artimerek.tbmd.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("https://api.themoviedb.org/3/"))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}