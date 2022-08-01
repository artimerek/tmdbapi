package pl.artimerek.tbmd.data.repository.artist.datasource

import pl.artimerek.tbmd.data.model.artist.ArtistList
import pl.artimerek.tbmd.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDatasource {

    suspend fun getArtists() : Response<ArtistList>
}