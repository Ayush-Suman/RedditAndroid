package a.suman.redditandroid.Data.Network

import io.reactivex.Single
import retrofit2.http.GET

interface RedNetMeth{

    @GET(".json")
    fun getFromNetwork(): Single<RedDataClass>
}