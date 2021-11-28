package weather.ui

import android.content.Context
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.example.nuclearweathercast.R
import com.example.nuclearweathercast.databinding.HourLayoutBinding

class HourView(context: Context): ConstraintLayout(context) {
    private lateinit var binding: HourLayoutBinding
    init {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(inflater, R.layout.hour_layout,this , true)
    }
    fun updateHour(hour: String) {
        binding.timeView.text = hour
    }
    fun updateTime(temp: Float) {
        binding.tempView.text = temp.toString()
    }
}