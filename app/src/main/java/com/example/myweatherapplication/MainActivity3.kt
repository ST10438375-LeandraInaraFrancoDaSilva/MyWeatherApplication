package com.example.myweatherapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.ArrayList

class MainActivity3 : AppCompatActivity() {
    // Declaring Variables privately
    private lateinit var detailsTextView: TextView
    private lateinit var AverageTextView: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        detailsTextView = findViewById(R.id.detailsTextView)
        AverageTextView = findViewById(R.id.averageTextView)
        backButton = findViewById(R.id.backButton)
        // Declaring variables
        val Day = intent.getStringArrayListExtra("Day Of Week") ?: arrayListOf()
        val MinTemp = intent.getStringArrayListExtra("Minimum Temperature") ?: arrayListOf()
        val MaxTemp = intent.getStringArrayListExtra("Maximum Temperature") ?: arrayListOf()
        val WeatherCond = intent.getStringArrayListExtra("Weather Condition") ?: arrayListOf()

        val details = StringBuilder()
        // Stipulating format in which details will be displayed
        for (i in Day.indices) {
            details.append("${Day[i]}:" + " Minimum Temperature - ${MinTemp[i]} C, Maximum Temperature -" +
                    "${MaxTemp[i]} C, Weather Condition - ${WeatherCond[i]}\n")
        }
        // Calculating average
        val AverageTemperature = if (Day.isNotEmpty()) MaxTemp + MinTemp / 2 else 0

        detailsTextView.text = details.toString()
        AverageTextView.text = "Average Temperature: $AverageTemperature C"
        // Allowing user to get back to the main page
        backButton.setOnClickListener {
            finish()
        }

    }
}

private operator fun <E> ArrayList<E>.div(i: Int): Any {
    TODO("Not yet implemented")
}


