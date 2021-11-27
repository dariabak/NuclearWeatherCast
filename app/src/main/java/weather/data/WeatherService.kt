package weather.data
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface WeatherServiceInterface {
    fun getForecast(lat: Double, lon: Double, handler: (WeatherDTO) -> Unit)
}
class WeatherService(private var queue: RequestQueue): WeatherServiceInterface {
    override fun getForecast(lat: Double, lon: Double, handler: (WeatherDTO) -> Unit) {
        var gson = Gson()
        val number = 7
        val url =
            "http://api.weatherapi.com/v1/forecast.json?key=bf95bec31cfe4c89a70122511212711&q=$lat,$lon&days=$number&aqi=no&alerts=no"
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                val string: String = response.toString()
                val weatherDtoType = object : TypeToken<WeatherDTO>() {}.type
                var weatherDTO: WeatherDTO = gson.fromJson(string, weatherDtoType)
                handler.invoke(weatherDTO)

            }, { error ->
                Log.e("WeatherService", "Error")
            }
        )
        queue.add(jsonObjectRequest)
    }
}