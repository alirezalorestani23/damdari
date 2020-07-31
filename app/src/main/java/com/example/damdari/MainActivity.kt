package com.example.damdari

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.samanpr.jalalicalendar.JalaliCalendar
import com.samanpr.jalalicalendar.JalaliCalendar.YearMonthDate
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val someHandler = Handler(mainLooper)
        someHandler.postDelayed(object : Runnable {
            override fun run() {
                tv_time.setText(SimpleDateFormat("HH:mm:ss", Locale.US).format(Date()))
                someHandler.postDelayed(this, 1000)
            }
        }, 10)

        val date = "2016-08-01 19:55:16"

        val parts = date.split(" ").toTypedArray()
        val datePart = parts[0]
        val timePart = parts[1]

        val year: Int
        val month: Int
        val day: Int

        val dateParts = datePart.split("-").toTypedArray()
        year = dateParts[0].toInt()
        month = dateParts[1].toInt()
        day = dateParts[2].toInt()

        val georgianDate = YearMonthDate(year, month, day)
        val JalaliDate: YearMonthDate = JalaliCalendar.gregorianToJalali(georgianDate)
        val jalaliDateTime: String = JalaliCalendar.toString().toString() + " " + timePart
//        tv_date.setText(jalaliDateTime)
    }


}
