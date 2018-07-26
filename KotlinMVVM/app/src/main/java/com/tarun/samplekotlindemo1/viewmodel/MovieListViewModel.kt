package com.tarun.samplekotlindemo1.viewmodel

import MovieDetails
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.tarun.samplekotlindemo1.extensions.toLiveData
import com.tarun.samplekotlindemo1.model.apiservices.MovieListDataContract
import com.tarun.samplekotlindemo1.rest.Outcome
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by TARUN on 09-Jul-18.
 */
class MovieListViewModel(val repository: MovieListDataContract.Repository,
                         val compositeDisposable: CompositeDisposable) : ViewModel() {

    val moviesOutcome: LiveData<Outcome<List<MovieDetails>>> by lazy {
        repository.moviesFetchOutcome.toLiveData(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}