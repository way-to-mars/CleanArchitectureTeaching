package ru.way2mars.exampledi.di

import dagger.Component
import ru.way2mars.exampledi.presentation.MainActivity

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}