package weather.data
import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

interface ServiceInterface {
    fun getForecast(lat: Double, lon: Double, handler: (ForecastDTO) -> Unit)
}
class Service(private var queue: RequestQueue): ServiceInterface {
    override fun getForecast(lat: Double, lon: Double, handler: (ForecastDTO) -> Unit) {
        val url =
            "http://api.weatherapi.com/v1/current.json?key=bf95bec31cfe4c89a70122511212711&q=$lat,$lon&aqi=no"
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                val jsonArray: JSONArray = response.getJSONArray("location")
               

            }, { error ->
                Log.e("Service", "Error")
            }
        )
        queue.add(jsonObjectRequest)
    }
}