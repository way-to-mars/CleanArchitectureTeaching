package ru.way2mars.exampledi.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.way2mars.exampledi.data.repository.DataRepositoryImplementation
import ru.way2mars.exampledi.data.storage.DataStorage
import ru.way2mars.exampledi.data.storage.sharedprefs.SharedPrefDataStorage
import ru.way2mars.exampledi.domain.repository.DataRepository
import ru.way2mars.exampledi.domain.usecase.GetDataUseCase
import ru.way2mars.exampledi.domain.usecase.SaveDataUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val sharedPrefDataStorage: DataStorage by lazy { SharedPrefDataStorage(context) }
    private val dataRepository: DataRepository by lazy {
        DataRepositoryImplementation(dataStorage = sharedPrefDataStorage)
    }
    private val getDataUseCase by lazy { GetDataUseCase(dataRepository) }
    private val saveDataUseCase by lazy { SaveDataUseCase(dataRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T{

        @Suppress("UNCHECKED_CAST")
        return MainViewModel(
            getDataUseCase = getDataUseCase,
            saveDataUseCase = saveDataUseCase,
        ) as T
    }

}