package com.damikkg.uicjetpackcompose.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.damikkg.uicjetpackcompose.R

class FirstFragment : Fragment() {

    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.counter).text = counter.toString()

        view.findViewById<Button>(R.id.nextScreenBtn).setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        view.findViewById<Button>(R.id.countUpBtn).setOnClickListener {
            counter++
            view.findViewById<TextView>(R.id.counter).text = counter.toString()
        }
    }
}
