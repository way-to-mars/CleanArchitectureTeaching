package ru.way2mars.exampledi.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.way2mars.exampledi.domain.models.SaveDataObject
import ru.way2mars.exampledi.domain.usecase.GetDataUseCase
import ru.way2mars.exampledi.domain.usecase.SaveDataUseCase

/**
 * Реализация вью-модели для *MainActivity*
 *
 * @constructor В конструктор передаются юс-кейсы.
 *
 * @param getDataUseCase юс-кейс для получения данных [GetDataUseCase].
 * @param saveDataUseCase юс-кейс для сохранения данных [SaveDataUseCase].
 */
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

    /**
     * Пытается сохранить [text] с помощью [saveDataUseCase].execute().
     *
     * Сообщает об успешности сохранения в объект [messageLiveMutable] в виде:
     *
     * "Save result: Ok" или "Save result: Failed"
     */
    fun save(text: String) {
        val result: Boolean = saveDataUseCase.execute(
            SaveDataObject(
                title = "Any title",
                message = text,
            )
        )
        messageLiveMutable.value = "Save result: ${if (result) "Ok" else "Failed"}"
    }

    /**
     * Получает объект [DataObject][ru.way2mars.exampledi.domain.models.DataObject] с помощью [getDataUseCase].execute().
     *
     * Передает поле message объекта [DataObject][ru.way2mars.exampledi.domain.models.DataObject] в объект [messageLiveMutable]
     */
    fun load() {
        val dataObject = getDataUseCase.execute()
        messageLiveMutable.value = dataObject.message
    }
}