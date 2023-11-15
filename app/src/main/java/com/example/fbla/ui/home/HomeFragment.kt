package com.example.fbla.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fbla.R
import com.example.fbla.databinding.FragmentHomeBinding



class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.text
        homeViewModel.text.observe(viewLifecycleOwner, { text ->
            textView.text = text
        })


        val myButton: Button = findViewById(R.id.myButton)

        myButton.setOnClickListener {
            print("hello world")
         }


        return root
    }

    private fun findViewById(myButton: Int): Button {

        return TODO("Provide the return value")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
