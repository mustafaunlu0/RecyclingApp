package com.example.recyclingapp.ui.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclingapp.R
import com.example.recyclingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding :ActivityMainBinding? = null
    @SuppressLint("UseCompatLoadingForColorStateLists")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.bottomNavigationView?.background = null
        binding?.bottomNavigationView?.menu?.getItem(2)?.isEnabled = false
        binding?.fab?.backgroundTintList = getResources().getColorStateList(R.color.green);
        binding?.fab?.imageTintList = getResources().getColorStateList(R.color.white);

    }
}