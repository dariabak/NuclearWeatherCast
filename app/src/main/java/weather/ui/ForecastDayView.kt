package weather.ui

import android.content.Context
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.example.nuclearweathercast.R
import com.example.nuclearweathercast.databinding.ForecastDayLayoutBinding
import weather.WeatherViewModel

class ForecastDayView(context: Context): ConstraintLayout(context) {
    private var binding: ForecastDayLayoutBinding
    init {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(inflater, R.layout.forecast_day_layout,this , true)
    }
    fun update(forecastViewModel: WeatherViewModel) {
        binding.maxtempView.text = forecastViewModel.max
        binding.mintempView.text = forecastViewModel.min
    }

}