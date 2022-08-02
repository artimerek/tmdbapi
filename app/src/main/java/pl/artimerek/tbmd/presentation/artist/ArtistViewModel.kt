package pl.artimerek.tbmd.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import pl.artimerek.tbmd.domain.usecase.GetArtistsUseCase
import pl.artimerek.tbmd.domain.usecase.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private  val updateArtistUseCase: UpdateArtistUseCase) : ViewModel() {

    fun getArtists() = liveData {
        val artists = getArtistsUseCase.execute()
        emit(artists)
    }

    fun updateArtists() = liveData {
        val artists = updateArtistUseCase.execute()
        emit(artists)
    }
}