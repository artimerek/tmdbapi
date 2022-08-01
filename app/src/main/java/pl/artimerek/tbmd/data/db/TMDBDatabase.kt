package pl.artimerek.tbmd.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.artimerek.tbmd.data.model.artist.Artist
import pl.artimerek.tbmd.data.model.movie.Movie
import pl.artimerek.tbmd.data.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDao
    abstract fun tvDao() : TvShowDao
    abstract fun artistDao() : ArtistDao
}