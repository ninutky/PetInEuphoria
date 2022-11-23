package com.example.petineuphoria

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReportProfile : AppCompatActivity() {
    lateinit var ivProfile: ImageView
    private var img_cnt = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_profile)
        supportActionBar?.hide()

        var TEXTVIEW = findViewById<TextView>(R.id.p_animal_name)

        val secondIntent = intent
        TEXTVIEW.text = secondIntent.getStringExtra("name")

        val prev = findViewById<Button>(R.id.prev_button)

        prev.setOnClickListener {
            super.onBackPressed()
        }
    }
}