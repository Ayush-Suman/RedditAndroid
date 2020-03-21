package a.suman.redditandroid.Data.Network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitRed {


    companion object {
        @Volatile
         private var retrofitRed: Retrofit? = null


        private fun RetrofitRed(): Retrofit {
            if (retrofitRed == null) {
                retrofitRed =
                    Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("https://www.reddit.com/r/Android/").build()
            }
            return retrofitRed!!
        }


        fun getNetworkMethods(): RedNetMeth {
            return RetrofitRed().create(RedNetMeth::class.java)
        }
    }
}