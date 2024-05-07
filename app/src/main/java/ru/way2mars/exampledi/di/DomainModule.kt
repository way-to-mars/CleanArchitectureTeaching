package ru.way2mars.exampledi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.way2mars.exampledi.domain.repository.DataRepository
import ru.way2mars.exampledi.domain.usecase.GetDataUseCase
import ru.way2mars.exampledi.domain.usecase.SaveDataUseCase

@Module
@InstallIn(ViewModelComponent::class)
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