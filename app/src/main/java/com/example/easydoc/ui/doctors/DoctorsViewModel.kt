package com.example.easydoc.ui.doctors

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DoctorsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is doctors Fragment"
    }
    val text: LiveData<String> = _text
}