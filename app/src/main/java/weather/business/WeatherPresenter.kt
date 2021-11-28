package weather.business

import weather.WeatherViewModel
import weather.ui.WeatherFragmentInterface
import java.text.SimpleDateFormat
import java.util.*

enum class WeatherImage {
    SUNNY,
    PARTLY_RAINY,
    MIST,
    RAIN,
    SLEET,
    CLOUDY,
    PARTLY_CLOUDY,
    SNOW,
    THUNDER

}
interface WeatherPresenterInterface {
    fun updateWeather(weather: Weather)
}
class WeatherPresenter(private val fragment: WeatherFragmentInterface): WeatherPresenterInterface {
    override fun updateWeather(weather: Weather) {
        fragment.updateCityAndCountry(weather.city, weather.country)
        fragment.createForecastDayView()
        for(i in 0 until weather.forecast.size) {
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            val currentDate = sdf.format(Date())

            var date = ""
            if(weather.forecast[i].date == currentDate.toString()) {
                date = "Today"
            } else {
                date = weather.forecast[i].date
            }
            var maxtemp: String = "H: " + weather.forecast[i].maxtemp.toString() + "°C"
            var mintemp: String = "L: " + weather.forecast[i].mintemp.toString() + "°C"

            var img = checkWhatImage(weather.forecast[i].img)
            if(img == "rain") {
                img = "rainy"
            } else if (img == "snow") {
                img = "snowy"
            }

            var desc = weather.forecast[i].img
            var maxwind = "Max wind: " + weather.forecast[i].maxwind + "mph"
            var viewModel = WeatherViewModel(maxtemp, mintemp, date, img, desc, maxwind)
            fragment.updateWeather(viewModel, i)

            fragment.updateHoursTemp(weather.forecast[i].hours, i)
        }
        fragment.hideLoadingView()

    }

    private fun checkWhatImage(title: String): String {
        val weather = enumValues<WeatherImage>()
        weather.forEach { it ->
            if(title.contains(it.toString().lowercase())){
                return it.toString().lowercase()
            }
        }
        return ""
    }
}