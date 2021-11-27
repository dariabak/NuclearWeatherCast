package weather.business

import weather.ui.WeatherFragmentInterface

interface PresenterInterface {

}
class Presenter(private val fragment: WeatherFragmentInterface): PresenterInterface {

}