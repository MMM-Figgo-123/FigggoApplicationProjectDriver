package com.figgo.cabs.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalassignment.utils.Event


class AuthViewModel() : ViewModel() {


    private var openWelcomeFragment: MutableLiveData<Event<Array<Any>>> =
        MutableLiveData<Event<Array<Any>>>()






    fun getOpenWelcomeFragment(): MutableLiveData<Event<Array<Any>>> {
        return openWelcomeFragment
    }

    fun setOpenWelcomeFragment(objects: Array<Any>) {
        openWelcomeFragment.value = Event(objects)
    }


}