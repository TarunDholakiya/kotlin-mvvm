package com.tarun.samplekotlindemo1.rest

import com.tarun.samplekotlindemo1.model.apiservices.MovieService

class ApiClient {
    companion object {
        fun getMovieService(): MovieService {
            return RetrofitConfig.getRetrofitInstance().create(MovieService::class.java)
        }
    }
}