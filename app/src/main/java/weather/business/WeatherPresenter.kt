package weather.business

import weather.WeatherViewModel
import weather.ui.WeatherFragmentInterface

interface WeatherPresenterInterface {
    fun updateWeather(weather: Weather)
}
class WeatherPresenter(private val fragment: WeatherFragmentInterface): WeatherPresenterInterface {
    override fun updateWeather(weather: Weather) {
        for(i in 0 until weather.forecast.size) {
            var viewModel = WeatherViewModel(weather.forecast.get(i).maxtemp.toString(), weather.forecast.get(i).mintemp.toString())
            fragment.updateWeather(viewModel, i)
        }
    }
}