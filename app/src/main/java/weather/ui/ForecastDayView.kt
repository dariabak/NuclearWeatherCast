package weather.ui

import android.content.Context
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.example.nuclearweathercast.R
import com.example.nuclearweathercast.databinding.ForecastDayLayoutBinding

class ForecastDayView(context: Context): ConstraintLayout(context) {
    private var binding: ForecastDayLayoutBinding
    init {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(inflater, R.layout.forecast_day_layout,this , true)
    }
}