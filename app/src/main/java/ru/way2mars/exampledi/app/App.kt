package ru.way2mars.exampledi.app

import android.app.Application
import dagger.Component
import ru.way2mars.exampledi.di.AppComponent
import ru.way2mars.exampledi.di.AppModule
import ru.way2mars.exampledi.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()

//        startKoin {
//            androidLogger(Level.DEBUG)
//            androidContext(this@App)
//            modules(
//                listOf(appModule, domainModule, dataModule)
//            )
//        }
    }
}