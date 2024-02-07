package com.example.recyclingapp.ui.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.recyclingapp.R
import com.example.recyclingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding :ActivityMainBinding? = null
    private lateinit var navController: NavController
    @SuppressLint("UseCompatLoadingForColorStateLists")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.bottomNavigationView?.background = null
        binding?.bottomNavigationView?.menu?.getItem(2)?.isEnabled = false
        binding?.fab?.backgroundTintList = resources.getColorStateList(R.color.green)
        binding?.fab?.imageTintList = resources.getColorStateList(R.color.white)

        navController = findNavController(R.id.fragmentContainerView)
        NavigationUI.setupWithNavController(binding?.bottomNavigationView!!,navController)

        binding?.fab?.setOnClickListener {
            navController.popBackStack()
            navController.navigate(R.id.mapsFragment)
        }


    }
}