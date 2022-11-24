package com.example.petineuphoria


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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*

class ReportRegisterActivity5 : AppCompatActivity() {
    val animal = Animal()
    var auth : FirebaseAuth? = null
    var firestore : FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_register5)
        supportActionBar?.hide()

        auth = Firebase.auth
        firestore = FirebaseFirestore.getInstance()

        val db = Firebase.firestore

        val done = findViewById<Button>(R.id.next_button)
        val prev = findViewById<Button>(R.id.prev_button)
        val chk = findViewById<CheckBox>(R.id.checkbox_cheese)
        val gratuity = findViewById<TextView>(R.id.gratuity)
        val gratuity_t = findViewById<TextView>(R.id.gratuity_t)
        val w_t = findViewById<EditText>(R.id.want_text)

        // 사례금 버튼 클릭하면
        chk.setOnClickListener(View.OnClickListener {
            if (chk.isChecked) {
                gratuity.setVisibility(View.VISIBLE)
                gratuity_t.setVisibility(View.VISIBLE)
            }
            else {
                gratuity.setVisibility(View.INVISIBLE)
                gratuity_t.setVisibility(View.INVISIBLE)
            }


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

        // 완료
        done.setOnClickListener {
            val intent = Intent(this,
                RegistrationCompletionActivity::class.java)
            startActivity(intent)
        }

        // 이전
        prev.setOnClickListener {
            super.onBackPressed()
        }




    }

}