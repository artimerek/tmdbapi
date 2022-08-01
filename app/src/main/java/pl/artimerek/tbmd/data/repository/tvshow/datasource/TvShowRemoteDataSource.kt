package pl.artimerek.tbmd.data.repository.tvshow.datasource

import pl.artimerek.tbmd.data.model.tvshow.TvShowList
import retrofit2.Response


interface TvShowRemoteDataSource {

    suspend fun getTvShowsFromRemote() : Response<TvShowList>
}