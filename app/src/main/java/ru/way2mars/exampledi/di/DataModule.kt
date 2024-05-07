package ru.way2mars.exampledi.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.way2mars.exampledi.data.repository.DataRepositoryImplementation
import ru.way2mars.exampledi.data.storage.DataStorage
import ru.way2mars.exampledi.data.storage.sharedprefs.SharedPrefDataStorage
import ru.way2mars.exampledi.domain.repository.DataRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideDataStorage(@ApplicationContext context: Context): DataStorage {
        return SharedPrefDataStorage(context)
    }

    @Provides
    @Singleton
    fun provideDataRepository(dataStorage: DataStorage): DataRepository {
        return DataRepositoryImplementation(dataStorage)
    }

}