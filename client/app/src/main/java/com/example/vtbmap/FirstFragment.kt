package com.example.vtbmap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenCreated
import androidx.navigation.fragment.findNavController
import com.example.vtbmap.databinding.FragmentFirstBinding
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.IconStyle
import com.yandex.runtime.image.ImageProvider
import org.koin.android.ext.android.inject
import retrofit2.Retrofit

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val vtbApi: VTBApi by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenCreated {
            val ls = vtbApi.getAllBanks().take(500)
            for (i in ls) {
                binding.mapview.map.mapObjects.addPlacemark().apply {
                    geometry = Point(i.latitude, i.longitude)
                    setIcon(ImageProvider.fromResource(requireContext(), com.yandex.maps.mobile.R.drawable.search_layer_pin_icon_default))
                    setText("VTB")
                    setIconStyle(
                        IconStyle(null, null, null, null, true, 1f, null)
                    )
                }
            }
        }


    }

    override fun onStart() {
        super.onStart()
        binding.mapview.onStart()
    }

    override fun onStop() {
        binding.mapview.onStop()
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}