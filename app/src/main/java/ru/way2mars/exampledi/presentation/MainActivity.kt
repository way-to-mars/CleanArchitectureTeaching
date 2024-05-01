package ru.way2mars.exampledi.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.way2mars.exampledi.R
import ru.way2mars.exampledi.data.repository.DataRepositoryImplementation
import ru.way2mars.exampledi.domain.models.SaveDataObject
import ru.way2mars.exampledi.domain.repository.DataRepository
import ru.way2mars.exampledi.domain.usecase.GetDataUseCase
import ru.way2mars.exampledi.domain.usecase.SaveDataUseCase


class MainActivity : AppCompatActivity() {

    private val dataRepository by lazy { DataRepositoryImplementation(context = applicationContext) }
    private val getDataUseCase by lazy { GetDataUseCase(dataRepository) }
    private val saveDataUseCase by lazy { SaveDataUseCase(dataRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<TextView>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener {
            println("Send Button clicked")
            val result = saveDataUseCase.execute(
                SaveDataObject(name = dataEditView.text.toString())
            )
            dataTextView.text = "Save result: ${if (result) "Ok" else "Failed"}"
        }

        receiveButton.setOnClickListener {
            println("Receive Button clicked")
            val dataObject = getDataUseCase.execute()
            dataTextView.text = dataObject.name
        }
    }
}