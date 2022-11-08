package com.example.petineuphoria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.skydoves.colorpickerview.ColorEnvelope
import com.skydoves.colorpickerview.ColorPickerView
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener


class FindRegisterActivity2 : AppCompatActivity() {
    private val textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_register2)
        supportActionBar?.hide()

        val next = findViewById<Button>(R.id.next_button)
        next.setOnClickListener {
            val intent = Intent(this,
                FindRegisterActivity3::class.java)
            startActivity(intent)
        }

//        findViewById<ColorPickerView>(R.id.colorPickerView).setColorListener(object: ColorListener {
//            override fun onColorSelected(color: Int, fromUser: Boolean) {
//                  Log.d("mytag", color.toString())
//                  findViewById<LinearLayout>(R.id.register_2_layout).setBackgroundColor(color)
//            }
//        })

//        findViewById<ColorPickerView>(R.id.colorPickerView).setColorListener(object: ColorEnvelopeListener {
//            override fun onColorSelected(envelope: ColorEnvelope?, fromUser: Boolean) {
//                val linearLayout: LinearLayout = findViewById(R.id.register_2_layout)
//                    linearLayout.setBackgroundColor(envelope.getColor());
//
//                textView.setText("#" + envelope.getHexCode());
//
//
//            }
//        })


    } //onCreate

//        buttonEvent = findViewById<View>(R.id.buttonEvent) as Button
//        buttonEvent!!.setOnTouchListener { view, motionEvent ->
//            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
//                buttonEvent!!.setBackgroundColor(Color.TRANSPARENT)
//            } else if (motionEvent.action == MotionEvent.ACTION_UP) {
//                buttonEvent!!.setBackgroundColor(Color.LTGRAY)
//            }
//            false
//        }
//    }



    // val colorPickerView = findViewById<ColorPickerView>(R.id.colorPickerView)
    // https://aries574.tistory.com/215
}