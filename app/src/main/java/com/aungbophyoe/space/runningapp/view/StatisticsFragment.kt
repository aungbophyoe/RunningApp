package com.aungbophyoe.space.runningapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aungbophyoe.space.runningapp.databinding.FragmentStatisticsBinding

class StatisticsFragment : Fragment() {
    private var _binding : FragmentStatisticsBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStatisticsBinding.inflate(inflater,container,false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}