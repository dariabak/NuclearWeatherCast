package weather.business

import weather.data.ForecastDayDTO
import weather.data.WeatherDTO

class Weather {
    constructor(weatherDTO: WeatherDTO) {
        this.city = weatherDTO.location.name
        this.country = weatherDTO.location.country
        this.forecast = weatherDTO.forecast.forecastday.map {Forecast(it)}.toCollection(java.util.ArrayList())
    }
    var city: String = ""
    var country: String = ""
    var forecast: ArrayList<Forecast> = ArrayList<Forecast>()
}
class Forecast() {
    constructor(forecastDayDTO: ForecastDayDTO) : this() {
        this.date = forecastDayDTO.date
        this.maxtemp = forecastDayDTO.day.maxtemp
        this.mintemp = forecastDayDTO.day.mintemp
        this.maxwind = forecastDayDTO.day.maxwind
        this.chanceOfRain = forecastDayDTO.day.chanceOfRain
    }
    var date: String = ""
    var maxtemp: Float = 0f
    var mintemp: Float = 0f
    var maxwind: Float = 0f
    var wind_dir: String = ""
    var chanceOfRain: Int = 0
}
