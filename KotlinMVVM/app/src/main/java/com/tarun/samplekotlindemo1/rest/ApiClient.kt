package com.tarun.samplekotlindemo1.rest

import android.content.Context
import com.tarun.simplekotlindemo.data.apiservices.MovieService

class ApiClient {
    companion object {
        fun getMovieService(activity: Context): MovieService {
            return RetrofitConfig.getRetrofitInstance(activity).create(MovieService::class.java)
        }
    }
}