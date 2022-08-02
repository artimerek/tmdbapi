package pl.artimerek.tbmd.presentation.di.artist

import dagger.Module
import dagger.Provides
import pl.artimerek.tbmd.domain.usecase.GetArtistsUseCase
import pl.artimerek.tbmd.domain.usecase.UpdateArtistUseCase
import pl.artimerek.tbmd.presentation.artist.ArtistViewModelFactory

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ) : ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistUseCase)
    }
}