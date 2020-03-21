package a.suman.redditandroid.Data

import a.suman.redditandroid.Data.Local.RedDatabase
import a.suman.redditandroid.Data.Local.RedTable
import a.suman.redditandroid.Data.Network.RetrofitRed
import android.app.Application
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import a.suman.redditandroid.Data.Network.RedDataClass as RedDataClass


class Repository(application: Application) {
    private val redMethods = RedDatabase.createDatabase(application).getRedMethods()
    private val redNetMeth = RetrofitRed.getNetworkMethods()


    fun loadData(): Single<List<RedTable>> {
        return redNetMeth.getFromNetwork().observeOn(Schedulers.computation()).map {
            return@map getRedTable(it)
        }
    }


    fun loadDataLocal(): Flowable<List<RedTable>> = redMethods.getAll()

    fun insertDataLocal(list: List<RedTable>)= redMethods.insertAll(list)

    private fun getRedTable(redDataClass: RedDataClass): List<RedTable> {
        val children = redDataClass.data.children
        return List(children.size, { return@List children[it].data })
    }


}