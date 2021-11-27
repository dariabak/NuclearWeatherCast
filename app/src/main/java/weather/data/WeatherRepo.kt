package weather.data

import weather.business.Weather

interface RepoInterface {
    fun getForecast(lat: Double, lon: Double, handler: (Weather) -> Unit)
}
class WeatherRepo(private val weatherService: WeatherServiceInterface): RepoInterface {

    override fun getForecast(lat: Double, lon: Double, handler: (Weather) -> Unit) {
        weatherService.getForecast(lat, lon) { weatherDTO ->
            var weather: Weather = Weather(weatherDTO)
            handler.invoke(weather)

        }
    }
}