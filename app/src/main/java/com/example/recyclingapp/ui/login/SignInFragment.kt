package com.example.recyclingapp.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.recyclingapp.R
import com.example.recyclingapp.databinding.FragmentSignInBinding
import com.example.recyclingapp.ui.main.MainActivity


class SignInFragment : Fragment() {

    private lateinit var binding:FragmentSignInBinding
    private lateinit var viewModel:SignInViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentSignInBinding.inflate(inflater,container,false)
        viewModel= ViewModelProvider(this).get(SignInViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toggleButton.addOnButtonCheckedListener { group, checkedId, isChecked ->
            if(isChecked)
            {
                when(checkedId)
                {
                    R.id.email_button->{
                        binding.emailLayout.visibility=View.VISIBLE
                        binding.phoneLayout.visibility=View.GONE
                    }
                    R.id.phone_button->{
                        binding.emailLayout.visibility=View.GONE
                        binding.phoneLayout.visibility=View.VISIBLE
                    }
                }
            }
        }
        binding.signUpTextview.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }
        binding.signInButton.setOnClickListener {
            if(checkIfNull())
            {
                viewModel.signIn(binding.emailEdittext.text.toString(),binding.passwordEdittext.text.toString())
                val intent= Intent(context,MainActivity::class.java)
                startActivity(intent)
                activity?.finish()

            }
        }
    }

    private fun checkIfNull():Boolean
    {
        return binding.emailEdittext.text.toString().isNotEmpty() && binding.passwordEdittext.text.toString()
            .isNotEmpty()
    }
}