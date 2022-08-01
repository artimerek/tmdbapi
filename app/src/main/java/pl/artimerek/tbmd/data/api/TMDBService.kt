package pl.artimerek.tbmd.data.api

import pl.artimerek.tbmd.data.model.artist.ArtistList
import pl.artimerek.tbmd.data.model.movie.MovieList
import pl.artimerek.tbmd.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey : String) : Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey : String) : Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey : String) : Response<ArtistList>

}
