package pl.artimerek.tbmd.data.repository.artist

import android.util.Log
import pl.artimerek.tbmd.data.model.artist.Artist
import pl.artimerek.tbmd.data.repository.artist.datasource.ArtistCacheDataSource
import pl.artimerek.tbmd.data.repository.artist.datasource.ArtistLocalDatasource
import pl.artimerek.tbmd.data.repository.artist.datasource.ArtistRemoteDatasource
import pl.artimerek.tbmd.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtissFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    private suspend fun getArtistsFromAPI() : List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (exception : Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return artistList
    }

    private suspend fun getArtistsFromDB() : List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDatasource.getArtistsFromDB()
        } catch (exception : Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDatasource.saveArtistsToDB(artistList)
        }

        return artistList
    }

    private suspend fun getArtissFromCache() : List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        } catch (exception : Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }

        return artistList
    }
}