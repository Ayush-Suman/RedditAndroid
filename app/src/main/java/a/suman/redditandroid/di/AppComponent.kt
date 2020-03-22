package a.suman.redditandroid.di

import a.suman.redditandroid.View.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

     fun inject(mainActivity: MainActivity)
}
