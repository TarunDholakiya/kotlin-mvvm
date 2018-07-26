package com.tarun.samplekotlindemo1.model.apiservices

import MovieDetails
import android.arch.lifecycle.LiveData
import com.tarun.samplekotlindemo1.rest.RemoteConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("?apikey=${RemoteConfig.API_KEY}")
    fun getMovieDetails(@Query("i") imdbId: String): LiveData<MovieDetails>
}