package ru.way2mars.exampledi.data.repository

import android.content.Context
import ru.way2mars.exampledi.domain.models.DataObject
import ru.way2mars.exampledi.domain.models.SaveDataObject
import ru.way2mars.exampledi.domain.repository.DataRepository
import java.lang.Exception

private const val SHARED_PREF_REPO_NAME = "shared_prefs_data_repository"
private const val KEY_NAME = "name"

/**
 * Класс слоя DATA.
 * Реализует интерфейс DataRepository (из слоя domain)
 */
class DataRepositoryImplementation(context: Context) : DataRepository {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF_REPO_NAME, Context.MODE_PRIVATE)

    override fun saveData(data: SaveDataObject): Boolean {
        sharedPreferences.edit().putString(KEY_NAME, data.name).apply()
        return true
    }

    override fun getData(): DataObject {
        return try {
            val name = sharedPreferences.getString(KEY_NAME, "Default name")
            DataObject(name!!)
        } catch (e: Exception) {
            DataObject("")
        }
    }
}