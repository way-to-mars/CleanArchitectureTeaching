package ru.way2mars.exampledi.di

import dagger.Module
import dagger.Provides
import org.koin.dsl.module
import ru.way2mars.exampledi.domain.repository.DataRepository
import ru.way2mars.exampledi.domain.usecase.GetDataUseCase
import ru.way2mars.exampledi.domain.usecase.SaveDataUseCase

@Module
class DomainModule {

    @Provides
    fun provideGetDataUseCase(repository: DataRepository): GetDataUseCase{
        return GetDataUseCase(repository)
    }

    @Provides
    fun provideSaveDataUseCase(repository: DataRepository): SaveDataUseCase{
        return SaveDataUseCase(repository)
    }

}