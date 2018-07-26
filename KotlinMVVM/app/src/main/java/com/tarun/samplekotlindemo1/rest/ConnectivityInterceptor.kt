package com.tarun.samplekotlindemo1.rest

import com.tarun.samplekotlindemo1.utilities.isOnline
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectivityInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val isNetworkActive = isOnline()
        return if (!isNetworkActive) {
            throw NoConnectivityException(message = String())
        } else {
            chain.proceed(chain.request())
        }
    }

    class NoConnectivityException(override var message: String) : IOException("No network available, please check your WiFi or Data connection")
}
