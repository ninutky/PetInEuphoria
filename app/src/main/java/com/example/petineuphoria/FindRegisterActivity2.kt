package com.example.petineuphoria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.skydoves.colorpickerview.ColorEnvelope
import com.skydoves.colorpickerview.ColorPickerView
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener


class FindRegisterActivity2 : AppCompatActivity() {
    private val textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_register2)
        supportActionBar?.hide()

        val next = findViewById<Button>(R.id.next_button)
        val prev = findViewById<Button>(R.id.prev_button)

        next.setOnClickListener {
            val intent = Intent(this,
                FindRegisterActivity3::class.java)
            startActivity(intent)
        }

        prev.setOnClickListener {
            val intent = Intent(this,
                FindRegisterActivity::class.java)
            startActivity(intent)
        }


    }
}