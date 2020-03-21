package a.suman.redditandroid

import a.suman.redditandroid.Data.Local.RedDatabase
import a.suman.redditandroid.Data.Local.RedMethod
import a.suman.redditandroid.Data.Local.RedTable
import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.awaitAll
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class RoomReadWriteUnitTest {
    private lateinit var redMethod: RedMethod
    private lateinit var db: RedDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, RedDatabase::class.java).build()
        redMethod = db.getRedMethods()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        val redTable = RedTable("abc", title = "ayush", thumbnail = "", url = "", selftext = "")
        redMethod.insertAll(listOf(redTable))
        redMethod.getAll().subscribe {
            assertThat(it[0], equalTo(redTable))}

    }
}
