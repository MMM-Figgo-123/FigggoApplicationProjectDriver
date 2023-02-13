package com.figgo.cabs.common

import android.view.View



/**
 *  Use this function to toggle view Visibility
 * **/

fun View.toggle(){
    if (this.visibility == View.VISIBLE){
        this.visibility = View.GONE
    }else{
        this.visibility = View.VISIBLE
    }
}