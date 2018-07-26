package com.tarun.samplekotlindemo1

import android.app.Application

/**
 * Created by TARUN on 10-Jul-18.
 */

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: MyApplication
            private set
    }
}
