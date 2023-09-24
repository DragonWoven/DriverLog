package com.dragonwoven.driverlog

import android.os.Handler
import android.os.Looper

class UpTimer(timerRun: () -> Unit) {
    val mainHandler = Handler(Looper.getMainLooper())





    val timerTextTask = object : Runnable {
        override fun run() {
            timerRun()
            mainHandler.postDelayed(this, 1000)

        }


    }

    fun Pause(){
        mainHandler.removeCallbacks(timerTextTask)
    }

    fun Unpause(){
        mainHandler.post(timerTextTask)
    }

}