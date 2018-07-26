package com.tarun.samplekotlindemo1.model.repository

import MovieDetails
import android.arch.lifecycle.LiveData
import com.tarun.samplekotlindemo1.rest.ApiClient

/**
 * Created by TARUN on 09-Jul-18.
 */
public class MovieRepository {
    companion object {
        fun getMovieList(imdbId: String): LiveData<MovieDetails> {
            return ApiClient.getMovieService().getMovieDetails(imdbId)
        }
    }
}