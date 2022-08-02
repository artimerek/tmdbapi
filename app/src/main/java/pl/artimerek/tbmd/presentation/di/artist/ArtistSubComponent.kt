package pl.artimerek.tbmd.presentation.di.artist

import dagger.Subcomponent
import pl.artimerek.tbmd.presentation.artist.ArtistActivity

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create() : ArtistSubComponent
    }
}