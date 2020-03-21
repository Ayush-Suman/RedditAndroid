package a.suman.redditandroid.Data.Local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RedTable::class], version = 1, exportSchema = false)
abstract class RedDatabase : RoomDatabase() {
    abstract fun getRedMethods(): RedMethod

    companion object {
        @Volatile
        private var instance: RedDatabase? = null
        fun createDatabase(application: Application): RedDatabase {
            if (instance == null) {
                val instance = Room.databaseBuilder(
                    application,
                    RedDatabase::class.java,
                    "Reddit"
                ).build()

                Companion.instance = instance
            }

            return Companion.instance!!
        }
    }
}


