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

    @SerializedName("hour")
    var hours: ArrayList<HourDTO> = ArrayList<HourDTO>()

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

    @SerializedName("condition")
    var condition: ConditionDTO = ConditionDTO()
}
class ConditionDTO {
    @SerializedName("text")
    var title: String = ""
}
class HourDTO {
    @SerializedName("temp_c")
    var hour_temp_c: Float = 0f
}