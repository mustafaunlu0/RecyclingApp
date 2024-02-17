package com.example.recyclingapp.ui.main.information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.recyclingapp.R
import com.example.recyclingapp.databinding.FragmentInformationBinding


class InformationFragment : Fragment() {

    private lateinit var binding:FragmentInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentInformationBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addBox.setOnClickListener {
            findNavController().navigate(R.id.action_informationFragment_to_homeFragment)
            findNavController().popBackStack()
        }
        binding.navigationIcon.setOnClickListener {
            findNavController().navigate(R.id.action_informationFragment_to_homeFragment)
            findNavController().popBackStack()
        }
    }
}