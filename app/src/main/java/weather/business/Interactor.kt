package weather.business

import weather.data.RepoInterface

interface InteractorInterface {
    fun getForecast(lat: Double, lon: Double)
}
class Interactor(private val presenter: PresenterInterface, private val repo: RepoInterface): InteractorInterface {
    override fun getForecast(lat: Double, lon: Double) {
        repo.getForecast(lat, lon) { forecast ->
            displayForecast(forecast)
        }
    }
    private fun displayForecast(forecast: Forecast) {

    }

}