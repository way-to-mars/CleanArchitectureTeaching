package ru.way2mars.exampledi.domain.usecase

import ru.way2mars.exampledi.domain.models.SaveDataObject
import ru.way2mars.exampledi.domain.repository.DataRepository

/**
 * Получает на вход объект, реализующий интерфейс DataRepository
 */
class SaveDataUseCase(private val repository: DataRepository) {

    fun execute(data: SaveDataObject) = repository.saveData(data)

}