package com.example.myweatherapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    //Declaring variables
    private lateinit var dayEditText: EditText
    private lateinit var minTempEditText: EditText
    private lateinit var maxTempEditText: EditText
    private lateinit var weatherCondEditText: EditText
    private val Day = ArrayList<String>()
    private val MinTemp = ArrayList<Int>()
    private val MaxTemp = ArrayList<Int>()
    private val WeatherCond = ArrayList<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

            dayEditText = findViewById(R.id.dayEditText)
            minTempEditText = findViewById(R.id.minTempEditText)
            maxTempEditText = findViewById(R.id.maxTempEditText)
            weatherCondEditText = findViewById(R.id.weatherCondEditText)
            val detailsButton = findViewById<Button>(R.id.detailsButton)
            val addButton = findViewById<Button>(R.id.addButton)
            val clearButton = findViewById<Button>(R.id.clearButton)
            val exitButton2 = findViewById<Button>(R.id.exitButton2)

            addButton.setOnClickListener {
                // Using addData function to input all details inserted by the user to the code
                addData()
            }

            clearButton.setOnClickListener {
                // clearing data so that the user can re-enter information
                clearData()
            }
                // linking the second page to the first one
            detailsButton.setOnClickListener {
                val intent = Intent (this, MainActivity3::class.java)
                intent.putStringArrayListExtra("Day Of the Week", Day)
                intent.putIntegerArrayListExtra("Minimum Temperature", MinTemp)
                intent.putIntegerArrayListExtra("Maximum Temperature", MaxTemp)
                intent.putStringArrayListExtra("Weather Conditions", WeatherCond)
                //start activity
                startActivity(intent)
            }
        // Allowing user to exit the app
        exitButton2.setOnClickListener {
            finish()
        }
        }

        private fun addData() {
            val day = dayEditText.text.toString()
            val minTemp = minTempEditText.text.toString().toIntOrNull()
            val maxTemp = maxTempEditText.text.toString().toIntOrNull()
            val weatherCond = weatherCondEditText.text.toString()

            if (day.isNotEmpty() && minTemp != null && maxTemp != null) {
                // Adding the data inputted to the arrays previously declared
                Day.add(day)
                MinTemp.add(minTemp)
                MaxTemp.add(maxTemp)
                WeatherCond.add(weatherCond)

                dayEditText.text.clear()
                minTempEditText.text.clear()
                maxTempEditText.text.clear()
                weatherCondEditText.text.clear()

                // Directly communicating to users
                Toast.makeText(this, "Information added successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill all fields correctly", Toast.LENGTH_SHORT).show()
            }
        }

        private fun clearData() {
            Day.clear()
            MinTemp.clear()
            MaxTemp.clear()
            WeatherCond.clear()

            dayEditText.text.clear()
            minTempEditText.text.clear()
            maxTempEditText.text.clear()
            weatherCondEditText.text.clear()

            Toast.makeText(this,"Information cleared", Toast.LENGTH_SHORT).show()
        }

    }


