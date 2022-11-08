package com.example.petineuphoria

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class FindRegisterActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_register5)

        var sd = findViewById<TextView>(R.id.startDate)

        // 텍스트뷰 누르면
        sd.setOnClickListener {
            val cal = Calendar.getInstance()

            val data = OnDateSetListener { view, year, month, day ->
                sd.setText("${year}/${month}/${day}")
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
//            dialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(WHAT);
//            dialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(resources.getColor(R.color.accentColor, theme))
        }

    }

}