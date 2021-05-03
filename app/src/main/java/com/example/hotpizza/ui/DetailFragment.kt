package com.example.hotpizza.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.hotpizza.R

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val namePizzaDetails = view.findViewById<TextView>(R.id.namePizzaDetail)

        val namePizza = arguments?.getString("namePizza")
        namePizzaDetails.text = namePizza

        return view
    }
}