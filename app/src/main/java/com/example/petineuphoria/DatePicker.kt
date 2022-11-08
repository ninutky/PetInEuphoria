package com.example.petineuphoria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import java.util.*

class DatePicker : AppCompatActivity() {
    private var mYear = 0
    private var mMonth = 0
    private var mDay = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_date_picker)
        val calendar: Calendar = GregorianCalendar()
        mYear = calendar[Calendar.YEAR]
        mMonth = calendar[Calendar.MONTH]
        mDay = calendar[Calendar.DAY_OF_MONTH]

//        val datePicker = findViewById<DatePicker>(R.id.vDatePicker)
//        datePicker.init(mYear, mMonth, mDay, mOnDateChangedListener)
    }

    fun mOnClick(v: View?) {
        val intent = Intent()
        intent.putExtra("mYear", mYear)
        intent.putExtra("mMonth", mMonth)
        intent.putExtra("mDay", mDay)
        setResult(RESULT_OK, intent)
        finish()
    }

//    var mOnDateChangedListener =
//        OnDateChangedListener { datePicker, yy, mm, dd ->
//            mYear = yy
//            mMonth = mm
//            mDay = dd
//        }
}