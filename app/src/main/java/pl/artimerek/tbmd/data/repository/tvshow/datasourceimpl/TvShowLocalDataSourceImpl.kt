package pl.artimerek.tbmd.data.repository.tvshow.datasourceimpl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.artimerek.tbmd.data.db.TvShowDao
import pl.artimerek.tbmd.data.model.tvshow.TvShow
import pl.artimerek.tbmd.data.repository.tvshow.datasource.TvShowLocalDataSource

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDataSource {

    override suspend fun getTvShows(): List<TvShow> = tvShowDao.getTvShows()


    override suspend fun deleteTvShows() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }

    override suspend fun saveTvShows(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }
}