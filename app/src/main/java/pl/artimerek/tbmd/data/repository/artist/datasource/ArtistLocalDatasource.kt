package pl.artimerek.tbmd.data.repository.artist.datasource

import pl.artimerek.tbmd.data.model.artist.Artist

interface ArtistLocalDatasource {

    suspend fun getArtistsFromDB() : List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAll()

}