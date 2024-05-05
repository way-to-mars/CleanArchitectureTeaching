package ru.way2mars.exampledi.data.repository

import ru.way2mars.exampledi.data.storage.models.DataModel
import ru.way2mars.exampledi.data.storage.DataStorage
import ru.way2mars.exampledi.domain.models.DataObject
import ru.way2mars.exampledi.domain.models.SaveDataObject
import ru.way2mars.exampledi.domain.repository.DataRepository


/**
 * Класс слоя DATA.
 * Реализует интерфейс DataRepository (из слоя domain)
 */
class DataRepositoryImplementation(private val dataStorage: DataStorage) : DataRepository {
    override fun saveData(data: SaveDataObject) =
        dataStorage.save(
            DataModel(title = data.title, message = data.message)
        )

    override fun getData(): DataObject {
        val dataModel = dataStorage.get()
        return DataObject(title = dataModel.title, message = dataModel.message)
    }
}