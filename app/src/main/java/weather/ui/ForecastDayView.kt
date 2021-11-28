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
import android.view.View
import android.view.ViewGroup
import weather.business.Hour


class ForecastDayView(context: Context): ConstraintLayout(context) {
    private var binding: ForecastDayLayoutBinding
    private lateinit var groupLayout: ViewGroup
    private var hoursArrayList = ArrayList<HourView>()
    init {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(inflater, R.layout.forecast_day_layout,this , true)
        groupLayout = binding.hoursLayout as ViewGroup
    }
    fun update(forecastViewModel: WeatherViewModel) {
        binding.maxtempView.text = forecastViewModel.max
        binding.mintempView.text = forecastViewModel.min
        binding.dateView.text = forecastViewModel.date
        val img = forecastViewModel.img
        val resID = context.resources.getIdentifier("drawable/" + img, null, context.getPackageName());
        binding.weatherImage.setImageResource(resID)
        binding.forecastDescView.text = forecastViewModel.desc
        binding.maxwindView.text = forecastViewModel.maxwind
    }
     fun createHoursView(hours: ArrayList<Hour>) {
         hours.forEach{ it ->
             var hour = HourView(context)
             hour.updateHour(it.hour.toString())
             hour.updateTime(it.temp_c.toString() + "°C")
             hoursArrayList.add(hour)
             groupLayout.addView(hour)
         }
    }
}