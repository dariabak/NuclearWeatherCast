package weather.business

import weather.WeatherViewModel
import weather.ui.WeatherFragmentInterface
import java.text.SimpleDateFormat
import java.util.*

interface WeatherPresenterInterface {
    fun updateWeather(weather: Weather)
}
class WeatherPresenter(private val fragment: WeatherFragmentInterface): WeatherPresenterInterface {
    override fun updateWeather(weather: Weather) {
        for(i in 0 until weather.forecast.size) {
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            val currentDate = sdf.format(Date())

            var date = ""
            if(weather.forecast[i].date == currentDate.toString()) {
                date = "Today"
            } else {
                date = weather.forecast[i].date
            }
            var maxtemp = weather.forecast.get(i).maxtemp.toString()
            var mintemp = weather.forecast.get(i).mintemp.toString()
            var viewModel = WeatherViewModel(maxtemp, mintemp, date)
            fragment.updateWeather(viewModel, i)
        }
        fragment.updateCityAndCountry(weather.city, weather.country)
    }
}