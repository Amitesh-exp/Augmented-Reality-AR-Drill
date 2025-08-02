package com.example.arassignment

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class DrillSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drill_selection)

        val spinner: Spinner = findViewById(R.id.spinnerDrills)
        val startButton: Button = findViewById(R.id.btnStartDrill)

        val drills = listOf("Drill 1", "Drill 2", "Drill 3")
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, drills)

        startButton.setOnClickListener {
            val intent = Intent(this, ARActivity::class.java)
            intent.putExtra("DRILL_NAME", spinner.selectedItem.toString())
            startActivity(intent)
        }
    }
}
