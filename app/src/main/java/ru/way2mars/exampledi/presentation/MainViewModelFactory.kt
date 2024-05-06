package ru.way2mars.exampledi.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.way2mars.exampledi.domain.usecase.GetDataUseCase
import ru.way2mars.exampledi.domain.usecase.SaveDataUseCase
import javax.inject.Inject

class MainViewModelFactory(
    private val getDataUseCase: GetDataUseCase,
    private val saveDataUseCase: SaveDataUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return MainViewModel(
            getDataUseCase = getDataUseCase,
            saveDataUseCase = saveDataUseCase
        ) as T
    }
}