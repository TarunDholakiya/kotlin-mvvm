package com.tarun.samplekotlindemo1.utilities

import android.content.Context
import android.net.ConnectivityManager
import com.tarun.samplekotlindemo1.MyApplication

fun isOnline(): Boolean {
    var isConnected = false
    try {
        val cm = MyApplication.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        isConnected = cm.activeNetworkInfo != null
                && cm.activeNetworkInfo.isAvailable
                && cm.activeNetworkInfo.isConnected
        if (isConnected) return isConnected
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return isConnected
}
