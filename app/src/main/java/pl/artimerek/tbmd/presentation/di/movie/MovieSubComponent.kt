package pl.artimerek.tbmd.presentation.di.movie

import dagger.Subcomponent
import pl.artimerek.tbmd.presentation.artist.ArtistActivity
import pl.artimerek.tbmd.presentation.movie.MovieActivity

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create() : MovieSubComponent
    }
}