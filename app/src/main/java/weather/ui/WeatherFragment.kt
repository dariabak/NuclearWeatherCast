package weather.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.nuclearweathercast.R
import androidx.databinding.DataBindingUtil
import com.ashiqur.weatherapp.utils.GPSUtils
import com.example.nuclearweathercast.databinding.WeatherFragmentLayoutBinding
import com.google.android.gms.location.*



private lateinit var fusedLocationClient: FusedLocationProviderClient

class WeatherFragment: Fragment(), ActivityCompat.OnRequestPermissionsResultCallback {
    private lateinit var binding: WeatherFragmentLayoutBinding
    private var permissionDenied = false
    private var lon: Double = 0.0
    private var lat: String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.weather_fragment_layout,
            container,
            false
        )

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return binding.root
        }
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location : Location? ->
                Log.d("", "")
                lon
            }

        return binding.root
    }

}
