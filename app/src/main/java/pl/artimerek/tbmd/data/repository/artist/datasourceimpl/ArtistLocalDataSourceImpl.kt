package pl.artimerek.tbmd.data.repository.artist.datasourceimpl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.artimerek.tbmd.data.db.ArtistDao
import pl.artimerek.tbmd.data.model.artist.Artist
import pl.artimerek.tbmd.data.repository.artist.datasource.ArtistLocalDatasource

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDatasource {

    override suspend fun getArtistsFromDB(): List<Artist> = artistDao.getArtists()

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}