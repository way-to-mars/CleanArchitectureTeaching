package ru.way2mars.exampledi.data.storage

import ru.way2mars.exampledi.data.storage.models.DataModel

interface DataStorage {
    fun save(dataModel: DataModel): Boolean
    fun get(): DataModel
}