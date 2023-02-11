package com.figgo.cabs.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalassignment.utils.Event


class AuthViewModel() : ViewModel() {


    private var openDashboardFragment: MutableLiveData<Event<Array<Any>>> =
        MutableLiveData<Event<Array<Any>>>()






    fun getOpenDashboardFragment(): MutableLiveData<Event<Array<Any>>> {
        return openDashboardFragment
    }

    fun setOpenDashboardFragment(objects: Array<Any>) {
        openDashboardFragment.value = Event(objects)
    }


}