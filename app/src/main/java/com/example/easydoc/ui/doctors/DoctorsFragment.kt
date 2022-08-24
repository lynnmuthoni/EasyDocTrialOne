package com.example.easydoc.ui.doctors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.easydoc.R
import com.example.easydoc.databinding.FragmentDoctorsBinding


class DoctorsFragment : Fragment() {

    private var _binding: FragmentDoctorsBinding? = null
    var departmentdentist:Button?=null
    var departmentdermatology:Button?=null
    var departmentorthopedics:Button?=null
    var departmentpedatrician:Button?=null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root =inflater.inflate(R.layout.fragment_doctors, container ,false)
        return root
        departmentdentist=f

    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}