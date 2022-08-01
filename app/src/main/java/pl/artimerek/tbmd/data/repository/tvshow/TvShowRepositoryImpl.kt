package pl.artimerek.tbmd.data.repository.tvshow

import android.util.Log
import pl.artimerek.tbmd.data.model.tvshow.TvShow
import pl.artimerek.tbmd.data.repository.tvshow.datasource.TvShowCacheDataSource
import pl.artimerek.tbmd.data.repository.tvshow.datasource.TvShowLocalDataSource
import pl.artimerek.tbmd.data.repository.tvshow.datasource.TvShowRemoteDataSource
import pl.artimerek.tbmd.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfShows = getTvShowsFromAPI()
        tvShowLocalDataSource.deleteTvShows()
        tvShowLocalDataSource.saveTvShows(newListOfShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfShows)
        return newListOfShows
    }

    private suspend fun getTvShowsFromAPI() : List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val response = tvShowRemoteDataSource.getTvShowsFromRemote()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        } catch (exception : Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return tvShowList
    }

    private suspend fun getTvShowsFromDB() : List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowLocalDataSource.getTvShows()
        } catch (exception : Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShows(tvShowList)
        }

        return tvShowList
    }

    private suspend fun getTvShowsFromCache() : List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        } catch (exception : Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }

        return tvShowList
    }
}