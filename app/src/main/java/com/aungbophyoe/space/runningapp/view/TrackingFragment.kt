package com.aungbophyoe.space.runningapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aungbophyoe.space.runningapp.databinding.FragmentTrackingBinding
import com.google.android.gms.maps.GoogleMap

class TrackingFragment : Fragment(){
    private var _binding : FragmentTrackingBinding? = null
    private val binding get() = _binding
    private var googleMap : GoogleMap? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTrackingBinding.inflate(inflater,container,false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            mapView.onCreate(savedInstanceState)
            mapView.getMapAsync {
                googleMap = it
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding?.mapView?.onDestroy()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        binding?.mapView?.onResume()
    }

    override fun onStart() {
        super.onStart()
        binding?.mapView?.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding?.mapView?.onResume()
    }

    override fun onStop() {
        super.onStop()
        binding?.mapView?.onResume()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding?.mapView?.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding?.mapView?.onSaveInstanceState(outState)
    }


}