package ru.way2mars.exampledi.domain.repository

import ru.way2mars.exampledi.domain.models.DataObject
import ru.way2mars.exampledi.domain.models.SaveDataObject

/**
 * Интерфейс репозитория. Находится в слое domain, а его реализации находятся в слое data.
 */
interface DataRepository {
    fun saveData(data: SaveDataObject) : Boolean
    fun getData() : DataObject
}