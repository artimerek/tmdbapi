package pl.artimerek.tbmd.domain.repository

import pl.artimerek.tbmd.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists() : List<Artist>?

    suspend fun updateArtists() : List<Artist>?
}