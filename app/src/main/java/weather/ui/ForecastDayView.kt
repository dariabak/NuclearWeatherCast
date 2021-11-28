package weather.ui

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.example.nuclearweathercast.R
import com.example.nuclearweathercast.databinding.ForecastDayLayoutBinding
import weather.WeatherViewModel
import android.graphics.drawable.Drawable




class ForecastDayView(context: Context): ConstraintLayout(context) {
    private var binding: ForecastDayLayoutBinding
    init {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(inflater, R.layout.forecast_day_layout,this , true)
    }
    fun update(forecastViewModel: WeatherViewModel) {
        binding.maxtempView.text = forecastViewModel.max
        binding.mintempView.text = forecastViewModel.min
        binding.dateView.text = forecastViewModel.date
        val res: Resources = resources
        val img = forecastViewModel.img
        val resID = context.getResources().getIdentifier("drawable/" + img, null, context.getPackageName());
        binding.weatherImage.setImageResource(resID)
        binding.forecastDescView.text = forecastViewModel.desc
    }

}