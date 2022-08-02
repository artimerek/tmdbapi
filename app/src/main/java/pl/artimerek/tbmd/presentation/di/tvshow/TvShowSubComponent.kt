package pl.artimerek.tbmd.presentation.di.tvshow

import dagger.Subcomponent
import pl.artimerek.tbmd.presentation.tvshows.TvShowActivity

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create() : TvShowSubComponent
    }
}