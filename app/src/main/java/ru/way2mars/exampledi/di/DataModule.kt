package ru.way2mars.exampledi.di

import org.koin.dsl.module
import ru.way2mars.exampledi.data.repository.DataRepositoryImplementation
import ru.way2mars.exampledi.data.storage.DataStorage
import ru.way2mars.exampledi.data.storage.sharedprefs.SharedPrefDataStorage
import ru.way2mars.exampledi.domain.repository.DataRepository

val dataModule = module {

    single<DataStorage> {
        SharedPrefDataStorage(context = get())
    }

    single<DataRepository> {
        DataRepositoryImplementation(dataStorage = get())
    }
}