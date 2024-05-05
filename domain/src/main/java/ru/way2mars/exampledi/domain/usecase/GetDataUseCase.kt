package ru.way2mars.exampledi.domain.usecase

import ru.way2mars.exampledi.domain.models.DataObject
import ru.way2mars.exampledi.domain.repository.DataRepository

/**
 * Получает на вход объект, реализующий интерфейс DataRepository
 */
class GetDataUseCase(private val repository: DataRepository) {
    fun execute() = repository.getData()
}