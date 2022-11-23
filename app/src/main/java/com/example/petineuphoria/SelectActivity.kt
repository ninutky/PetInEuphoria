package com.example.petineuphoria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)
        supportActionBar?.hide()

        var b1 = findViewById<Button>(R.id.o)
        var b2 = findViewById<Button>(R.id.t)

        b1.setOnClickListener {
            val intent = Intent(this,
                ReportRegisterActivity::class.java)
            startActivity(intent)
        }

        b2.setOnClickListener {
            val intent = Intent(this,
                FindRegisterActivity::class.java)
            startActivity(intent)
        }
    }
}