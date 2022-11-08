package com.example.petineuphoria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val login = findViewById<Button>(R.id.login)
        val sign_Up = findViewById<Button>(R.id.sign_up)

        /*
        login.setOnClickListener {
            val intent = Intent(this,
                LoginActivity::class.java)
            startActivity(intent)
        }
        sign_Up.setOnClickListener {
            val intent = Intent(this,
                SignUpActivity::class.java)
            startActivity(intent)
        }
        */
    }
}