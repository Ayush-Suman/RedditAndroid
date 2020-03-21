package a.suman.redditandroid

import a.suman.redditandroid.Data.Network.RedNetMeth
import a.suman.redditandroid.Data.Network.RetrofitRed
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NetworkUnitTest {
    private lateinit var redNetMeth:RedNetMeth

    @Before
    fun initRetro(){
        redNetMeth=RetrofitRed.getNetworkMethods()
    }

    @Test
    fun networkCall(){
        redNetMeth.getFromNetwork().test()
    }

}
