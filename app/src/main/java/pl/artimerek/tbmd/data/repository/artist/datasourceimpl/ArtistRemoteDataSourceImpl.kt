package pl.artimerek.tbmd.data.repository.artist.datasourceimpl

import pl.artimerek.tbmd.data.api.TMDBService
import pl.artimerek.tbmd.data.model.artist.ArtistList
import pl.artimerek.tbmd.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmbdService: TMDBService,
    private val apiKey:String
) : ArtistRemoteDatasource {

    override suspend fun getArtists(): Response<ArtistList> = tmbdService.getPopularArtists(apiKey)

}