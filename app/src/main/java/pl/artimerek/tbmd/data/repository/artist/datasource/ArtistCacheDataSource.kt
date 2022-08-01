package pl.artimerek.tbmd.data.repository.artist.datasource

import pl.artimerek.tbmd.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache() : List<Artist>
    suspend fun saveArtistsToCache(artists : List<Artist>)
}