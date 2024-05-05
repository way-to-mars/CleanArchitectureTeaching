package ru.way2mars.exampledi.di

import org.koin.dsl.module
import ru.way2mars.exampledi.domain.usecase.GetDataUseCase
import ru.way2mars.exampledi.domain.usecase.SaveDataUseCase

val domainModule = module {

    factory<GetDataUseCase> {
        GetDataUseCase(repository = get())
    }

    factory<SaveDataUseCase> {
        SaveDataUseCase(repository = get())
    }
}