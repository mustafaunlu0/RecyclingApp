package com.example.recyclingapp.ui.main.profile.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclingapp.R
import com.example.recyclingapp.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {

    private lateinit var binding:FragmentHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHistoryBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter=HistoryAdapter()
        binding.historyRecyclerView.adapter=adapter
        binding.historyRecyclerView.layoutManager=LinearLayoutManager(context)
        binding.navigationIcon.setOnClickListener {
            findNavController().navigate(R.id.action_historyFragment_to_profileFragment)
            findNavController().popBackStack()
        }
    }


}