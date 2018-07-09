package com.tarun.samplekotlindemo1.utilities

import android.content.Context
import android.net.ConnectivityManager

fun isOnline(activity: Context): Boolean {
    var isConnected = false
    try {
        val cm = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        isConnected = cm.activeNetworkInfo != null
                && cm.activeNetworkInfo.isAvailable
                && cm.activeNetworkInfo.isConnected
        if (isConnected) return isConnected
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return isConnected
}
