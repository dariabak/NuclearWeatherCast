package weather.business

import weather.ui.WeatherFragmentInterface

interface WeatherPresenterInterface {
    fun updateWeather()
}
class WeatherPresenter(private val fragment: WeatherFragmentInterface): WeatherPresenterInterface {
    override fun updateWeather() {
        TODO("Not yet implemented")
    }
}