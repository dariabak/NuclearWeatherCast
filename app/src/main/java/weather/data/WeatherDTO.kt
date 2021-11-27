package weather.data

import com.google.gson.annotations.SerializedName


class WeatherDTO {

    @SerializedName("location")
    var location: LocationDTO = LocationDTO()

    @SerializedName("forecast")
    var forecast: FForecastDTO = FForecastDTO()

}

class LocationDTO {

    @SerializedName("name")
    var name: String = ""
    @SerializedName("country")
    var country: String = ""
}

class FForecastDTO {

    @SerializedName("forecastday")
    var forecastday: ArrayList<ForecastDayDTO> = ArrayList<ForecastDayDTO>()

}
class ForecastDayDTO {

    @SerializedName("date")
    var date: String = ""

    @SerializedName("day")
    var day: DayDTO = DayDTO()

}
class DayDTO {
    @SerializedName("maxtemp_c")
    var maxtemp: Float = 0f

    @SerializedName("mintemp_c")
    var mintemp: Float = 0f

    @SerializedName("maxwind_mph")
    var maxwind: Float = 0f

    @SerializedName("daily_chance_of_rain")
    var chanceOfRain: Int = 0
}