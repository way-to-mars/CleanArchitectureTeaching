package ru.way2mars.exampledi.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import ru.way2mars.exampledi.R
import ru.way2mars.exampledi.app.App
import ru.way2mars.exampledi.basicutils.con
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var vmFactory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        (applicationContext as App).appComponent.inject(this)

        Log.e("404", "MainActivity created")

        viewModel = ViewModelProvider(this, vmFactory)[MainViewModel::class.java]
        viewModel.con(
            message = viewModel.hashCode().toString(radix = 16)
        ) {
            "Scope = " + viewModel.viewModelScope.toString()
        }

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<TextView>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        viewModel.messageLive.observe(this) { dataTextView.text = it }

        sendButton.setOnClickListener {
            println("Send Button clicked")
            viewModel.save(dataEditView.text.toString())
        }

        receiveButton.setOnClickListener {
            println("Receive Button clicked")
            viewModel.load()
        }
    }
}