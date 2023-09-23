package com.dragonwoven.driverlog
import com.dragonwoven.driverlog.databinding.ActivityMainBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var going = false

        val mainHandler = Handler(Looper.getMainLooper())
        var i = 0

        fun timeDisplay(seconds:Int){
            var sec = seconds
            var minutes = 0
            var hours = 0
            while (sec > 60){
                minutes++
                sec -= 60
            }
            while(minutes > 60){
                hours++
                minutes - 60
            }
            if (hours != 0){
                binding.tvTest.setText(hours.toString() + ":" + minutes.toString() + ":" + sec.toString())
            }
            if (minutes != 0 && hours == 0){
                binding.tvTest.setText(minutes.toString() + ":" + sec.toString())
            }
            if(hours == 0 && minutes == 0){
                binding.tvTest.setText(sec.toString())
            }

        }

        val timerTextTask = object : Runnable {
            override fun run() {
                i = i+1
                timeDisplay(i)
                mainHandler.postDelayed(this, 1000)
            }
        }


        binding.btntest.setOnClickListener(){
            if (!going){
                going = true
                mainHandler.post(timerTextTask)
            }
            else{
                going = false
                mainHandler.removeCallbacks(timerTextTask)
            }
        }
    }



    }
