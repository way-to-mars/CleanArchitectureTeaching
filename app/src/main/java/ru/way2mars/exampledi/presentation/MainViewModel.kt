package ru.way2mars.exampledi.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.way2mars.exampledi.domain.models.SaveDataObject
import ru.way2mars.exampledi.domain.usecase.GetDataUseCase
import ru.way2mars.exampledi.domain.usecase.SaveDataUseCase

class MainViewModel(
    private val getDataUseCase: GetDataUseCase,
    private val saveDataUseCase: SaveDataUseCase,
) : ViewModel() {

    private val messageLiveMutable = MutableLiveData<String>()
    val messageLive: LiveData<String>
        get() = messageLiveMutable

    override fun onCleared() {
        super.onCleared()
    }


    fun save(text: String) {
        val result: Boolean = saveDataUseCase.execute(
            SaveDataObject(
                title = "Any title",
                message = text,
            )
        )
        messageLiveMutable.value = "Save result: ${if (result) "Ok" else "Failed"}"
    }

    fun load() {
        val dataObject = getDataUseCase.execute()
        messageLiveMutable.value = dataObject.message
    }
}