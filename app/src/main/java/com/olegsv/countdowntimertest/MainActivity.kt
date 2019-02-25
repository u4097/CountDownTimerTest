package com.olegsv.countdowntimertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var myCountDownTimer: MyCountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_timer.setOnClickListener {
            myCountDownTimer = MyCountDownTimer(10000, 1000)
            myCountDownTimer!!.start()
        }

        stop_timer.setOnClickListener {
            myCountDownTimer!!.cancel()
        }
    }

    inner class MyCountDownTimer(millisInFuture: Long, countDownInterval: Long) :
        CountDownTimer(millisInFuture, countDownInterval) {

        override fun onTick(millisUntilFinished: Long) {

            val progress = (millisUntilFinished / 1000).toInt()

            progressBar.progress = progressBar.max - progress
        }

        override fun onFinish() {
            finish()
        }
    }
}
