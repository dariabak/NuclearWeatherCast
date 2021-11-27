package weather.data

import weather.business.Forecast

interface RepoInterface {
    fun getForecast(lat: Double, lon: Double, handler: (Forecast) -> Unit)
}
class Repo( private val service: ServiceInterface): RepoInterface {

    override fun getForecast(lat: Double, lon: Double, handler: (Forecast) -> Unit) {
        service.getForecast(lat, lon) { forecastDTO ->
            //....

        }
    }
}