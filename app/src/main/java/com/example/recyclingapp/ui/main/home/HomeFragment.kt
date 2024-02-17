package com.example.recyclingapp.ui.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclingapp.R
import com.example.recyclingapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val adapter = ProductAdapter { onItemClick() }
    private var binding : FragmentHomeBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.productRecyclerview?.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding?.productRecyclerview?.adapter = adapter
        binding?.infoCardview?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_informationFragment)
        }


    }

    private fun onItemClick(){
        findNavController().navigate(R.id.action_homeFragment_to_ticketFragment)
    }


}