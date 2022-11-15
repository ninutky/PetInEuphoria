package com.example.petineuphoria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FindRegisterActivity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_register4)
        supportActionBar?.hide()

        val next = findViewById<Button>(R.id.next_button)
        val prev = findViewById<Button>(R.id.prev_button)

        next.setOnClickListener {
            val intent = Intent(this,
                FindRegisterActivity5::class.java)
            startActivity(intent)
        }

        prev.setOnClickListener {
            super.onBackPressed()
        }



    }


}