package com.figgo.cabs.common

class IListeners {

    interface  IClickListener{
        fun onItemClick()

    }

    interface IPrefListener{
        fun onPrefChanged(key:String)
    }
}