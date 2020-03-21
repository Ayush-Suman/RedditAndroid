package a.suman.redditandroid.Data.Local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface RedMethod {
    @Query("Select * From RedTable")
    fun getAll(): Flowable<List<RedTable>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<RedTable>)
}