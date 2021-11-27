package weather.data

interface RepoInterface {
    fun getForecast(lon: Double, lat: Double)
}
class Repo( private val service: ServiceInterface): RepoInterface {

    override fun getForecast(lon: Double, lat: Double) {
        var forecast = service.getForecast(lon, lat)
    }
}