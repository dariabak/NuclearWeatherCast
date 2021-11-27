package weather.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nuclearweathercast.R
import androidx.databinding.DataBindingUtil
import com.example.nuclearweathercast.databinding.WeatherFragmentLayoutBinding

class WeatherFragment: Fragment() {
    private lateinit var binding: WeatherFragmentLayoutBinding
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.weather_fragment_layout,
            container,
            false
        )




        return binding.root
    }
}