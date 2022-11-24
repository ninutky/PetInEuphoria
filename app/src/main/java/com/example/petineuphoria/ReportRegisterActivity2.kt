package com.example.petineuphoria

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class ReportRegisterActivity2 : AppCompatActivity() {
    var auth : FirebaseAuth? = null
    var firestore : FirebaseFirestore? = null
//    val animal = intent.getSerializableExtra("key") as Animal
    val animal = Animal()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_register2)
        supportActionBar?.hide()

        auth = Firebase.auth
        firestore = FirebaseFirestore.getInstance()


        val db = Firebase.firestore

        val next = findViewById<Button>(R.id.next_button)
        val prev = findViewById<Button>(R.id.prev_button)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
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

        // 체크박스
        var color = 0
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                R.id.color1 -> animal.color = 1
                R.id.color2 -> animal.color = 2
                R.id.color3 -> animal.color = 3
                R.id.color4 -> animal.color = 4
                R.id.color5 -> animal.color = 5

            }
        }

        // 여자나 남자를 택하면
        var g_cnt = 0
        var b_cnt = 0
        girl_btn?.setOnClickListener {
            girl_btn?.isSelected = girl_btn?.isSelected != true
            boy_btn.setSelected(false)
            g_cnt++
            b_cnt = 0
        }
        boy_btn?.setOnClickListener {
            boy_btn?.isSelected = boy_btn?.isSelected != true
            girl_btn.setSelected(false)
            b_cnt++
            g_cnt = 0
        }

        // 강아지나 고양이를 택하면
        var d_cnt = 0
        var c_cnt = 0

        dog_btn?.setOnClickListener {
            dog_btn?.isSelected = dog_btn?.isSelected != true
            cat_btn.setSelected(false)
            d_cnt++
            c_cnt=0
        }
        cat_btn?.setOnClickListener {
            cat_btn?.isSelected = cat_btn?.isSelected != true
            dog_btn.setSelected(false)
            c_cnt++
            d_cnt=0
        }

        // 다음 버튼 누르면
        next.setOnClickListener {
            if ((g_cnt==0&&b_cnt==0)||(g_cnt%2==0&&b_cnt%2==0))
                Toast.makeText(this, "성별을 선택해주세요.", Toast.LENGTH_SHORT).show()
            else if ((d_cnt==0&&c_cnt==0)||(d_cnt%2==0&&c_cnt%2==0))
                Toast.makeText(this, "동물을 선택해주세요.", Toast.LENGTH_SHORT).show()
            else if (isNull(text1.getText().toString()))
                Toast.makeText(this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
            else if (isNull(text2.getText().toString()))
                Toast.makeText(this, "나이를 입력해주세요.", Toast.LENGTH_SHORT).show()
            else if (isNull(text3.getText().toString()))
                Toast.makeText(this, "견종 / 묘종을 입력해주세요.", Toast.LENGTH_SHORT).show()
            else {
                // 액티비티 3으로 감, 값 전달
                val intent = Intent(this,
                    ReportRegisterActivity3::class.java)

                animal.gender = isGender(g_cnt, b_cnt)
                animal.dog_or_cat = isDogOrCat(d_cnt, c_cnt)
                animal.a_color = color
//
                animal.name = text1.getText().toString()
                animal.age = text2.getText().toString()
                animal.breed =text3.getText().toString()
//                animal.update("name", text1.getText().toString())
//                animal.update("age", text2.getText().toString())
//                animal.update("breed", text3.getText().toString())
                db.collection("animal").document(FirebaseAuth.getInstance().currentUser?.uid.toString()).update("gender", animal.gender.toString())
                db.collection("animal").document(FirebaseAuth.getInstance().currentUser?.uid.toString()).update("dog_or_cat", animal.dog_or_cat.toString())
                db.collection("animal").document(FirebaseAuth.getInstance().currentUser?.uid.toString()).update("a_color", animal.a_color.toString())
                db.collection("animal").document(FirebaseAuth.getInstance().currentUser?.uid.toString()).update("name", animal.name.toString())
                db.collection("animal").document(FirebaseAuth.getInstance().currentUser?.uid.toString()).update("age", animal.age.toString())
                db.collection("animal").document(FirebaseAuth.getInstance().currentUser?.uid.toString()).update("breed", animal.breed.toString())
                startActivity(intent)
            }

        }

        // 이전 버튼
        prev.setOnClickListener {
            super.onBackPressed()
        }

        // 털색 체크박스 버튼을 누르면 체크표시
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

    // 빈칸 있는지 없는지
    fun isNull(str: String?): Boolean {
        var returnValue = false
        if (str == null || str == "" || str.length == 0) {
            returnValue = true
        }
        return returnValue
    }

    // 성별 구분
    fun isGender(g: Int, b: Int): Boolean {
        // 여 선택 = true, 남 선택 = false
        if (b == 0 || b % 2 == 0) {
            return true
        } else {
            return false
        }
    }

    // 동물 구분
    fun isDogOrCat(d: Int, c: Int): Boolean {
        // 강아지 선택 = true, 고양이 선택 = false
        if (c == 0 || c % 2 == 0) {
            return true
        } else {
            return false
        }
    }

}