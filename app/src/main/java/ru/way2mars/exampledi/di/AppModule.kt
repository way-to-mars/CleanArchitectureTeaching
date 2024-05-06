package ru.way2mars.exampledi.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.way2mars.exampledi.domain.usecase.GetDataUseCase
import ru.way2mars.exampledi.domain.usecase.SaveDataUseCase
import ru.way2mars.exampledi.presentation.MainViewModelFactory

@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    fun provideMainViewModelFactory(
        getDataUseCase: GetDataUseCase,
        saveDataUseCase: SaveDataUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(
            getDataUseCase = getDataUseCase,
            saveDataUseCase = saveDataUseCase
        )
    }
}