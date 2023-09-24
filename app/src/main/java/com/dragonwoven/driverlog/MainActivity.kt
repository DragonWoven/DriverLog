package com.dragonwoven.driverlog
import com.dragonwoven.driverlog.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var going = false



        fun timeDisplay(seconds:Int){
            var text = ""
            var sec = seconds
            var minutes = 0
            var hours = 0
            while (sec > 60){
                minutes++
                sec -= 60
            }
            while (minutes > 60){
                minutes -= 60
                hours += 1
            }
            if (hours != 0){
                text = "$hours:$minutes:$sec"
            }
            if (minutes != 0 && hours == 0){
                text = "$minutes:$sec"
            }
            if(hours == 0 && minutes == 0){
                text = sec.toString()
            }
            binding.tvTest.text = text

        }

        var i = 0
        fun onTimeSec(){
            i += 1
            timeDisplay(i)
        }
        val timer = UpTimer(::onTimeSec)
        timer.pause()

        binding.btntest.setOnClickListener{
            if (!going){
                going = true
                timer.unpause()
            }
            else{
                going = false
                timer.pause()
            }
        }
    }
}
