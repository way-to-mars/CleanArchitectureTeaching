package ru.way2mars.exampledi.data.storage.sharedprefs

import android.content.Context
import ru.way2mars.exampledi.data.storage.DataStorage
import ru.way2mars.exampledi.data.storage.models.DataModel
import java.lang.Exception

private const val SHARED_PREF_REPO_NAME = "shared_prefs_data_repository"
private const val KEY_TITLE = "title"
private const val KEY_MESSAGE = "message"

class SharedPrefDataStorage(context: Context) : DataStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREF_REPO_NAME, Context.MODE_PRIVATE)
    override fun save(dataModel: DataModel): Boolean {
        sharedPreferences.edit()
            .putString(KEY_TITLE, dataModel.title)
            .putString(KEY_MESSAGE, dataModel.message)
            .apply()
        return true
    }

    override fun get() = DataModel(
        title = getStringOrDefault(KEY_TITLE, "Default title"),
        message = getStringOrDefault(KEY_MESSAGE, "Default message"),
    )

    private fun getStringOrDefault(key: String, default: String): String {
        return try {
            sharedPreferences.getString(key, default) ?: default
        } catch (e: Exception) {
            default
        }
    }
}