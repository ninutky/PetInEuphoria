package com.example.petineuphoria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FindProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_profile)
        supportActionBar?.hide()
    }
}