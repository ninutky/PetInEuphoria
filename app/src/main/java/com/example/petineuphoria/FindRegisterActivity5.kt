package com.example.petineuphoria

import CustomTextWatcher
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class FindRegisterActivity5 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_register5)
        supportActionBar?.hide()

        val done = findViewById<Button>(R.id.next_button)
        val prev = findViewById<Button>(R.id.prev_button)
        val chk = findViewById<CheckBox>(R.id.checkbox_cheese)
        val gratuity_t = findViewById<TextView>(R.id.gratuity)
        val w_t = findViewById<EditText>(R.id.want_text)

        // 완료
        done.setOnClickListener {
            val intent = Intent(
                this,
                FindProfile::class.java
            )
            startActivity(intent)
        }

        // 이전
        prev.setOnClickListener {
            super.onBackPressed()
        }

        var sd = findViewById<TextView>(R.id.startDate)

        // 텍스트뷰 누르면
        sd.setOnClickListener {
            val cal = Calendar.getInstance()

            val data = OnDateSetListener { view, year, month, day ->
                sd.setText("${year}년 ${month}월 ${day}일")
            }

            val dialog = DatePickerDialog(
                this,
                data,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            )
            dialog.show()
            dialog.datePicker.spinnersShown = true
            dialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(resources.getColor(R.color.black, theme))
            dialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(resources.getColor(R.color.black, theme))
        }

        chk.setOnClickListener(View.OnClickListener {
            if (chk.isChecked)
                gratuity_t.setVisibility(View.VISIBLE)
            else
                gratuity_t.setVisibility(View.INVISIBLE)

        })

        // 엔터
        w_t.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(w_t.getWindowToken(), 0) //hide keyboard
                return@OnKeyListener true
            }
            false
        })


    }

}