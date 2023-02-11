package com.figgo.cabs.db

import android.content.Context
import com.figgo.cabs.app.App
import com.figgo.cabs.common.IListeners
import com.figgo.cabs.models.Driver
import com.google.gson.Gson

class SharedPreferences {

    companion object {
        var instance: SharedPreferences? = null
        var sp: android.content.SharedPreferences? = null
        lateinit var listener: IListeners.IPrefListener
        var PREF = "FiggoDriverPreference"
        var KEY_USER_INFO = "UserInfo"

        @JvmName("getInstance1")
        fun getInstance(): SharedPreferences {
            if (instance == null) {
                instance = SharedPreferences()

            }
            sp = App.context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
            return instance!!
        }


    }

    fun addUser(userModel: Driver) {
        try {
            val gson = Gson()
            val json = gson.toJson(userModel)
            val editor = sp?.edit();
            editor?.putString(KEY_USER_INFO, json)
            editor?.apply()
            editor?.commit()
            listener.onPrefChanged(KEY_USER_INFO)
        } catch (e: Exception) {
        }
    }


    fun getUserInfo(): Driver? {
        var userModel: Driver? = null
        try {
            val gson = Gson()
            val string = sp?.getString(KEY_USER_INFO, "")
            if (string?.length!! > 0) {
                userModel = gson.fromJson(string, Driver::class.java)
            }


        } catch (e: Exception) {
        }


        return userModel;
    }


}