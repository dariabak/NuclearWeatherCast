package weather.ui

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.nuclearweathercast.R
import androidx.databinding.DataBindingUtil
import com.android.volley.toolbox.Volley
import com.example.nuclearweathercast.databinding.WeatherFragmentLayoutBinding
import com.google.android.gms.location.*
import weather.business.WeatherInteractor
import weather.business.InteractorInterface
import weather.business.WeatherPresenter
import weather.business.WeatherPresenterInterface
import weather.data.WeatherRepo
import weather.data.RepoInterface
import weather.data.WeatherService
import weather.data.WeatherServiceInterface

interface WeatherFragmentInterface {
    fun updateWeather()
}


private lateinit var fusedLocationClient: FusedLocationProviderClient

class WeatherFragment: Fragment(), WeatherFragmentInterface {
    private lateinit var layout: ViewGroup
    private lateinit var interactor: InteractorInterface
    private lateinit var binding: WeatherFragmentLayoutBinding
    private var lon: Double = 0.0
    private var lat: Double = 0.0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.weather_fragment_layout,
            container,
            false
        )
        layout = binding.forecastdaysLayout as ViewGroup
        var weatherPresenter: WeatherPresenterInterface = WeatherPresenter(this)
        val queue = Volley.newRequestQueue(context)
        var weatherService: WeatherServiceInterface = WeatherService(queue)
        var repo: RepoInterface = WeatherRepo(weatherService)
        interactor = WeatherInteractor(weatherPresenter, repo)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        getLastLocation()
        createForecastDayView()
        return binding.root
    }

    private fun getLastLocation() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location : Location? ->
                Log.d("", "")
                lon = location?.longitude!!
                lat = location?.latitude!!
                interactor.getForecast(lat, lon)

            }
    }

    fun createForecastDayView() {
        for(i in 0..2) {
            var day = ForecastDayView(requireContext())
            layout.addView(day)
        }
    }
    override fun updateWeather() {
        TODO("Not yet implemented")
    }
}
