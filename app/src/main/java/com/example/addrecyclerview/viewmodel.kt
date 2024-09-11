package com.example.addrecyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class viewmodel:ViewModel() {
    private val _userlist=MutableLiveData<MutableList<patient_information>>()
    val userlist:MutableLiveData<MutableList<patient_information>>get()= _userlist
    fun addlist(patientInformation: patient_information){
        val list=_userlist.value
        list?.add(patientInformation)
        userlist.value=list
    }

}