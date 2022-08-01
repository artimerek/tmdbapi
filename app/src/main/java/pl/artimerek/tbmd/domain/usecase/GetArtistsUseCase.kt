package pl.artimerek.tbmd.domain.usecase

import pl.artimerek.tbmd.data.model.artist.Artist
import pl.artimerek.tbmd.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute() : List<Artist>? = artistRepository.getArtists()
}