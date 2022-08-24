package com.example.easydoc.ui.appointment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.easydoc.R


class CallsFragment : Fragment() {
//Inflate the Layout
override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
) =
    inflater.inflate(R.layout.fragment_currentappointments, container, false)!!
}
