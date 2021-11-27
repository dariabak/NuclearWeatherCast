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
import com.example.nuclearweathercast.databinding.WeatherFragmentLayoutBinding
import com.google.android.gms.location.*
import weather.business.Interactor
import weather.business.InteractorInterface
import weather.business.Presenter
import weather.business.PresenterInterface
import weather.data.Repo
import weather.data.RepoInterface
import weather.data.Service
import weather.data.ServiceInterface

interface WeatherFragmentInterface {

}


private lateinit var fusedLocationClient: FusedLocationProviderClient

class WeatherFragment: Fragment(), WeatherFragmentInterface {
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
        var presenter: PresenterInterface = Presenter(this)
        var service: ServiceInterface = Service()
        var repo: RepoInterface = Repo(service)
        interactor = Interactor(presenter, repo)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        getLastLocation()

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


            }
    }

}
