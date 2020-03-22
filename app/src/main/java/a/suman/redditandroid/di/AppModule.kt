package a.suman.redditandroid.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(application: Application) {

    var mApplication=application

    @Provides
    @Singleton
    fun providesApplication():Application{
        return mApplication
    }
}
