package com.tarun.simplekotlindemo.data.apiservices

import MovieDetails
import com.tarun.samplekotlindemo1.rest.RemoteConfig
import io.reactivex.Observable

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("?apikey=${RemoteConfig.API_KEY}")
    fun getMovieDetails(@Query("i") imdbId: String): Observable<MovieDetails>
}