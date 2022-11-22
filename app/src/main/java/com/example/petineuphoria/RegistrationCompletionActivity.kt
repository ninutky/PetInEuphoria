package com.example.petineuphoria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegistrationCompletionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_completion)
        supportActionBar?.hide()

        val done = findViewById<Button>(R.id.next_button)

        done.setOnClickListener {
            val intent = Intent(this,
                HomeActivity::class.java)
            startActivity(intent)
        }
    }
}