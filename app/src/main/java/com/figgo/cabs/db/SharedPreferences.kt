package com.figgo.cabs.db

import android.content.Context
import android.util.Log
import com.figgo.cabs.app.App
import com.figgo.cabs.common.IListeners
import com.figgo.cabs.models.Driver
import com.google.gson.Gson

const val TAG = "SHARED PREFERENCES ERROR"

class SharedPreferences {

    companion object {
        var instance: SharedPreferences? = null
        var sp: android.content.SharedPreferences? = null
        lateinit var listener: IListeners.IPrefListener


        @JvmName("getInstance1")
        fun getInstance(): SharedPreferences {
            if (instance == null) {
                instance = SharedPreferences()

            }
            sp = App.context.getSharedPreferences(
                FiggoDatabaseDefinitions.PREF_NAME,
                Context.MODE_PRIVATE
            )
            return instance!!
        }


    }

    fun addUserInfo(userModel: Driver) {
        try {
            val gson = Gson()
            val json = gson.toJson(userModel)
            val editor = sp?.edit();
            editor?.putString(FiggoDatabaseDefinitions.KEY_USER_INFO, json)
            editor?.apply()
            editor?.commit()
            listener.onPrefChanged(FiggoDatabaseDefinitions.KEY_USER_INFO)
        } catch (e: Exception) {
            Log.e(TAG, e.toString())
        }
    }


    fun getUserInfo(): Driver? {
        var userModel: Driver? = null
        try {
            val gson = Gson()
            val string = sp?.getString(FiggoDatabaseDefinitions.KEY_USER_INFO, "")
            if (string?.length!! > 0) {
                userModel = gson.fromJson(string, Driver::class.java)
            }


        } catch (e: Exception) {
            Log.e(TAG, e.toString())
        }


        return userModel;
    }

    fun setLoginStatus(key: Boolean) {
        try {

            val editor = sp?.edit();
            editor?.putBoolean(FiggoDatabaseDefinitions.KEY_IS_LOGGED_IN, key)
            editor?.apply()
            editor?.commit()
        } catch (e: Exception) {
            Log.e(TAG, e.toString())
        }
    }

    fun isLoggedIn(): Boolean {
        var status = false
        try {
            status = sp?.getBoolean(FiggoDatabaseDefinitions.KEY_IS_LOGGED_IN, false)!!

        } catch (e: Exception) {
            Log.e(TAG, e.toString())
        }

        return status
    }

    fun setApprovalStatus(key: Boolean) {
        try {

            val editor = sp?.edit();
            editor?.putBoolean(FiggoDatabaseDefinitions.KEY_IS_APPROVED, key)
            editor?.apply()
            editor?.commit()
        } catch (e: Exception) {
            Log.e(TAG, e.toString())
        }
    }

    fun isApproved(): Boolean {
        var status = false
        try {
            status = sp?.getBoolean(FiggoDatabaseDefinitions.KEY_IS_APPROVED, false)!!

        } catch (e: Exception) {
            Log.e(TAG, e.toString())
        }

        return status
    }


    fun setFirstInstall(key: Boolean) {
        try {

            val editor = sp?.edit();
            editor?.putBoolean(FiggoDatabaseDefinitions.KEY_IS_FIRST_INSTALL, key)
            editor?.apply()
            editor?.commit()
        } catch (e: Exception) {
            Log.e(TAG, e.toString())
        }
    }

    fun isFirstInstall(): Boolean {
        var status = true
        try {
            status = sp?.getBoolean(FiggoDatabaseDefinitions.KEY_IS_FIRST_INSTALL, true)!!

        } catch (e: Exception) {
            Log.e(TAG, e.toString())
        }

        return status
    }


}