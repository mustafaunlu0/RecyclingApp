package com.example.recyclingapp.ui.main.ticket

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.recyclingapp.R
import com.example.recyclingapp.databinding.FragmentTicketBinding


class TicketFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    private var cardViewText: String = ""
    lateinit var binding: FragmentTicketBinding
    private var kg: Int = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTicketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireContext().getSharedPreferences(
            requireContext().packageName,
            Context.MODE_PRIVATE
        )

        binding.time1.setOnClickListener {
            cardViewText = binding.time1Textview.text.toString()
        }
        binding.time2.setOnClickListener {
            cardViewText = binding.time2Textview.text.toString()
        }
        binding.time3.setOnClickListener {
            cardViewText = binding.time3Textview.text.toString()
        }

        binding.addPoint.setOnClickListener {
            kg++
            binding.kgTextview.text = kg.toString()
        }
        binding.removePoint.setOnClickListener {
            if (kg > 10) {
                kg--
                binding.kgTextview.text = kg.toString()
            }
        }


        binding.createButton.setOnClickListener {
            /*
            with(sharedPreferences.edit()){
                putString("productName", binding.nameTextview.text.toString())
                putString("point", binding.nameTextview.text.toString())
                putString("kg",binding.kgTextview.text.toString())
                putString("desc",binding.descTextview.text.toString())
                putString("time",cardViewText)
            }

             */
            findNavController().navigate(R.id.action_ticketFragment_to_mapsFragment2)

        }
    }


}