package ru.way2mars.exampledi.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.way2mars.exampledi.presentation.MainViewModel

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(
            getDataUseCase = get(),
            saveDataUseCase = get(),
        )
    }
}