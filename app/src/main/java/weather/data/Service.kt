package weather.data
interface ServiceInterface {
    fun getForecast(lon: Double, lat: Double)
}
class Service: ServiceInterface {

    override fun getForecast(lon: Double, lat: Double) {
        TODO("Not yet implemented")
    }
}