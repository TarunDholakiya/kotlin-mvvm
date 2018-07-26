package com.tarun.samplekotlindemo1.application

import android.app.Application

/**
 * Created by TARUN on 26-Jul-18.
 */
open class MyApplication : Application() {
    companion object {
        lateinit var myApplicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {

    }
}