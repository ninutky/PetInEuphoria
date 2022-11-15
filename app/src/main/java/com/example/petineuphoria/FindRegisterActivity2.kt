package com.example.petineuphoria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class FindRegisterActivity2 : AppCompatActivity() {
    var selected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_register2)
        supportActionBar?.hide()

        val db = Firebase.firestore

        val next = findViewById<Button>(R.id.next_button)
        val prev = findViewById<Button>(R.id.prev_button)
        val girl_btn = findViewById<Button>(R.id.g_btn)
        val boy_btn = findViewById<Button>(R.id.b_btn)
        val dog_btn = findViewById<Button>(R.id.d_btn)
        val cat_btn = findViewById<Button>(R.id.c_btn)
        val text1 = findViewById<EditText>(R.id.animal_name)
        val text2 = findViewById<EditText>(R.id.animal_age)
        val text3 = findViewById<EditText>(R.id.animal_breed)
        var cb1 = findViewById<RadioButton>(R.id.color1)
        var cb2 = findViewById<RadioButton>(R.id.color2)
        var cb3 = findViewById<RadioButton>(R.id.color3)
        var cb4 = findViewById<RadioButton>(R.id.color4)
        var cb5 = findViewById<RadioButton>(R.id.color5)

        var g_cnt = 0
        var b_cnt = 0

        girl_btn?.setOnClickListener {
            girl_btn?.isSelected = girl_btn?.isSelected != true
            boy_btn.setSelected(false)
            g_cnt = 1
            b_cnt = 0
        }

        boy_btn?.setOnClickListener {
            boy_btn?.isSelected = boy_btn?.isSelected != true
            girl_btn.setSelected(false)
            b_cnt = 1
            g_cnt = 0
        }

        var d_cnt = 0
        var c_cnt = 0

        dog_btn?.setOnClickListener {
            dog_btn?.isSelected = dog_btn?.isSelected != true
            cat_btn.setSelected(false)
            d_cnt=1
            c_cnt=0
        }

        cat_btn?.setOnClickListener {
            cat_btn?.isSelected = cat_btn?.isSelected != true
            dog_btn.setSelected(false)
            c_cnt=1
            d_cnt=0
        }



        next.setOnClickListener {
            if (d_cnt==0&&c_cnt==0)
                Toast.makeText(this, "동물을 선택해주세요.", Toast.LENGTH_SHORT).show()
            else if (isNull(text1.getText().toString()))
                Toast.makeText(this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
            else if (isNull(text2.getText().toString()))
                Toast.makeText(this, "나이를 입력해주세요.", Toast.LENGTH_SHORT).show()
            else if (isNull(text3.getText().toString()))
                Toast.makeText(this, "견종 / 묘종을 입력해주세요.", Toast.LENGTH_SHORT).show()
            else {
                val intent = Intent(this,
                    FindRegisterActivity3::class.java)
                startActivity(intent)
            }

        }



        prev.setOnClickListener {
            super.onBackPressed()
        }

        cb1.setOnClickListener {
            check(true)
        }

        cb2.setOnClickListener {
            check(true)
        }

        cb3.setOnClickListener {
            check(true)
        }

        cb4.setOnClickListener {
            check(true)
        }

        cb5.setOnClickListener {
            check(true)
        }


    }

    fun isNull(str: String?): Boolean {
        var returnValue = false
        if (str == null || str == "" || str.length == 0) {
            returnValue = true
        }
        return returnValue
    }
}