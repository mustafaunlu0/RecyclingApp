package com.example.recyclingapp.ui.main.profile

import android.content.Intent
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.recyclingapp.R
import com.example.recyclingapp.databinding.FragmentProfileBinding
import com.example.recyclingapp.ui.login.LoginActivity
import com.example.recyclingapp.ui.main.MainActivity

class ProfileFragment : Fragment() {

    private lateinit var binding:FragmentProfileBinding
    private lateinit var viewModel:ProfileViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentProfileBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this).get(ProfileViewModel::class.java)
        binding.logOut.setOnClickListener {
            viewModel.signOut()
            val intent=Intent(context,LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
        binding.history.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_historyFragment)
        }
    }
}