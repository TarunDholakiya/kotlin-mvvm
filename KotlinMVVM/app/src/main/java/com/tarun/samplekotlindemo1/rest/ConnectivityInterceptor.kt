package com.tarun.samplekotlindemo1.rest

import android.content.Context
import com.tarun.samplekotlindemo1.utilities.isOnline
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectivityInterceptor internal constructor(private val activity: Context) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val isNetworkActive = isOnline(activity)
        return if (!isNetworkActive) {
            throw NoConnectivityException(message = String())
        } else {
            chain.proceed(chain.request())
        }
    }

    class NoConnectivityException(override var message: String) : IOException("No network available, please check your WiFi or Data connection")
}
