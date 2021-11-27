package weather.business

import weather.data.RepoInterface

interface InteractorInterface {
    fun getForecast(lon: Double, lat: Double)
}
class Interactor(private val presenter: PresenterInterface, private val repo: RepoInterface): InteractorInterface {
    override fun getForecast(lon: Double, lat: Double) {
        var forecast = repo.getForecast(lon, lat)
    }

}