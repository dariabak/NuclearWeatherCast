package weather.business

import weather.data.RepoInterface

interface InteractorInterface {
    fun getForecast(lat: Double, lon: Double)
}
class WeatherInteractor(private val weatherPresenter: WeatherPresenterInterface, private val repo: RepoInterface): InteractorInterface {
    override fun getForecast(lat: Double, lon: Double) {
        repo.getForecast(lat, lon) { forecast ->
            updateForecast(forecast)
        }
    }
    private fun updateForecast(weather: Weather) {
        weatherPresenter.updateWeather(weather)
    }

}