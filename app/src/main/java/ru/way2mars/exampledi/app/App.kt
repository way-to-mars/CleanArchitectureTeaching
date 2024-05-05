package ru.way2mars.exampledi.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.way2mars.exampledi.di.appModule
import ru.way2mars.exampledi.di.dataModule
import ru.way2mars.exampledi.di.domainModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(
                listOf(appModule, domainModule, dataModule)
            )
        }
    }
}