package weather.business

import weather.data.ForecastDayDTO
import weather.data.HourDTO
import weather.data.WeatherDTO
import java.text.SimpleDateFormat
import kotlin.math.round

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
        this.chanceOfRain = forecastDayDTO.day.chanceOfRain
        this.img = forecastDayDTO.day.condition.title
        this.maxwind = round(forecastDayDTO.day.maxwind).toInt()
        this.hours = forecastDayDTO.hours.map { Hour(it)}.toCollection(java.util.ArrayList())
    }
    var date: String = ""
    var maxtemp: Float = 0f
    var mintemp: Float = 0f
    var maxwind: Int = 0
    var chanceOfRain: Int = 0
    var img: String = ""
    var hours: ArrayList<Hour> = ArrayList<Hour>()

}
class Hour {
    constructor(hourDTO: HourDTO) {
        this.temp_c = hourDTO.hour_temp_c
        this.hour = hourDTO.time.takeLast(5)
    }
    var hour: String = ""
    var temp_c: Float = 0f
}
