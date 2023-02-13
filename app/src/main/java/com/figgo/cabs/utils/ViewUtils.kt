package com.figgo.cabs.utils

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.figgo.cabs.R

class ViewUtils {

    companion object {
        fun showToast(context: Context, msg: String) {

            val customToastLayout = (context as Activity).layoutInflater.inflate(
                R.layout.layout_toast,
                (context as Activity).findViewById(R.id.toastContainer)
            )
            val customToast = Toast(context)
            val text: TextView = customToastLayout.findViewById(R.id.tvToastMsg)
            text.text = msg
            customToast.view = customToastLayout
            customToast.setGravity(Gravity.CENTER, 0, 0)
            customToast.duration = Toast.LENGTH_SHORT
            customToast.show()

        }
    }
}