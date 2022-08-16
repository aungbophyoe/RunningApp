package com.aungbophyoe.space.runningapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aungbophyoe.space.runningapp.R
import com.aungbophyoe.space.runningapp.databinding.FragmentSetupBinding

class SetUpFragment : Fragment(){
    private var _binding : FragmentSetupBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSetupBinding.inflate(inflater,container,false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.apply {
            btnContinue.setOnClickListener {
                findNavController().navigate(R.id.action_setUpFragment_to_runFragment)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}