package com.example.petineuphoria

import android.app.DatePickerDialog.OnDateSetListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import java.util.*

class ReportRegisterActivity4 : AppCompatActivity() {
    val animal = Animal()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_register4)
        supportActionBar?.hide()

        val next = findViewById<Button>(R.id.next_button)
        val prev = findViewById<Button>(R.id.prev_button)

        val db = Firebase.firestore

        db.collection("animal").document(FirebaseAuth.getInstance().currentUser?.uid.toString()).update("date", animal.date)

        var date = findViewById<TextView>(R.id.startDate)

        // 텍스트뷰 누르면
        date.setOnClickListener {
            val cal = Calendar.getInstance()

            val data = OnDateSetListener { view, year, month, day ->
                date.setText("${year}년 ${month}월 ${day}일")
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

        next.setOnClickListener {
            val intent = Intent(this,
                ReportRegisterActivity5::class.java)
            startActivity(intent)
        }

        prev.setOnClickListener {
            super.onBackPressed()
        }



    }


}