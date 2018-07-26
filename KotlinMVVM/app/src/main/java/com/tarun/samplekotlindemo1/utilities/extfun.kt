package com.tarun.samplekotlindemo1.utilities

import Movie
import android.app.Activity
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.widget.Toast
import io.reactivex.*

fun ArrayList<Movie>.getMoviesByReleaseYear(year: Int): List<Movie> {
    return this.filter { movie -> movie.releaseYear > year }
}

fun ArrayList<Movie>.getMoviesAfterThis(releaseYear: Int): List<Movie> {
    return this.filter { movie -> movie.releaseYear > releaseYear }
}

fun ArrayList<Movie>.getMovieHavingStar(starName: String): List<Movie> {
    return this.filter { movie -> movie.stars!!.contains(starName) }
}

fun ArrayList<Movie>.getMovieHavingDirector(starName: String): List<Movie> {
    return this.filter { movie -> movie.directors!!.contains(starName) }
}

fun <T> Flowable<T>.toLiveData(): LiveData<T> {
    return LiveDataReactiveStreams.fromPublisher(this)
}

fun <T> Observable<T>.toLiveData(backPressureStrategy: BackpressureStrategy): LiveData<T> {
    return LiveDataReactiveStreams.fromPublisher(this.toFlowable(backPressureStrategy))
}

fun <T> Single<T>.toLiveData(): LiveData<T> {
    return LiveDataReactiveStreams.fromPublisher(this.toFlowable())
}

fun <T> Maybe<T>.toLiveData(): LiveData<T> {
    return LiveDataReactiveStreams.fromPublisher(this.toFlowable())
}

fun <T> Completable.toLiveData(): LiveData<T> {
    return LiveDataReactiveStreams.fromPublisher(this.toFlowable())
}

fun Activity.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}