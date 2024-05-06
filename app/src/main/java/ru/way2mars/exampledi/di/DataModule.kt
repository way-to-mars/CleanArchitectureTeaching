package ru.way2mars.exampledi.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.way2mars.exampledi.data.repository.DataRepositoryImplementation
import ru.way2mars.exampledi.data.storage.DataStorage
import ru.way2mars.exampledi.data.storage.sharedprefs.SharedPrefDataStorage
import ru.way2mars.exampledi.domain.repository.DataRepository


@Module
class DataModule {

    @Provides
    fun provideDataStorage(context: Context): DataStorage {
        return SharedPrefDataStorage(context)
    }

    @Provides
    fun provideDataRepository(dataStorage: DataStorage): DataRepository {
        return DataRepositoryImplementation(dataStorage)
    }

}