package com.tarun.samplekotlindemo1.data.repository

import MovieDetails
import android.app.Activity
import android.util.Log
import com.tarun.samplekotlindemo1.rest.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by TARUN on 09-Jul-18.
 */
public class MovieRepository {
    private lateinit var movieDetails: MovieDetails
    fun getMovieList(activity: Activity, imdbId: String) {
        ApiClient.getMovieService(activity).getMovieDetails(imdbId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t ->
                    return@subscribe
                }, { throwable ->
                    Log.i("MovieRepository", " : " + throwable.message)
                })
    }
}