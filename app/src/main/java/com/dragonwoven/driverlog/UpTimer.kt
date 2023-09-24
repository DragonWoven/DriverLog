package com.dragonwoven.driverlog

import android.os.Handler
import android.os.Looper

class UpTimer(timerRun: () -> Unit) {
    val mainHandler = Handler(Looper.getMainLooper())





    private val timerTextTask = object : Runnable {
        override fun run() {
            timerRun()
            mainHandler.postDelayed(this, 1000)

        }


    }

    fun pause(){
        mainHandler.removeCallbacks(timerTextTask)
    }

    fun unpause(){
        mainHandler.post(timerTextTask)
    }

}