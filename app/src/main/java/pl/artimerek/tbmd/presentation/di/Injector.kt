package pl.artimerek.tbmd.presentation.di

import pl.artimerek.tbmd.presentation.di.artist.ArtistSubComponent
import pl.artimerek.tbmd.presentation.di.movie.MovieSubComponent
import pl.artimerek.tbmd.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent() : MovieSubComponent
    fun createTvShowSubComponent() : TvShowSubComponent
    fun createArtistSubComponent() : ArtistSubComponent
}