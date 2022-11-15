package com.example.petineuphoria

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class FindRegisterActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_register3)
        supportActionBar?.hide()

        val next = findViewById<Button>(R.id.next_button)
        val prev = findViewById<Button>(R.id.prev_button)
        val text1 = findViewById<EditText>(R.id.animal_characteristic)


        next.setOnClickListener {
            if (isNull(text1.getText().toString()))
                Toast.makeText(this, "특징을 입력해주세요.", Toast.LENGTH_SHORT).show()
            else {
                val intent = Intent(this,
                    FindRegisterActivity4::class.java)
                startActivity(intent)
            }
        }

        prev.setOnClickListener {
            super.onBackPressed()
        }

        text1.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KEYCODE_ENTER) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(text1.getWindowToken(), 0) //hide keyboard
                return@OnKeyListener true
            }
            false
        })


    }

    fun isNull(str: String?): Boolean {
        var returnValue = false
        if (str == null || str == "" || str.length == 0) {
            returnValue = true
        }
        return returnValue
    }



}

