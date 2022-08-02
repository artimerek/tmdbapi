package pl.artimerek.tbmd.presentation.di.tvshow

import dagger.Module
import dagger.Provides
import pl.artimerek.tbmd.domain.usecase.GetTvShowsUseCase
import pl.artimerek.tbmd.domain.usecase.UpdateTvShowsUseCase
import pl.artimerek.tbmd.presentation.tvshows.TvShowViewModelFactory

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ) : TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}