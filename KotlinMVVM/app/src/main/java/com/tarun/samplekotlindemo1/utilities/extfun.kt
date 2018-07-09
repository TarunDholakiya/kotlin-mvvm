package com.tarun.samplekotlindemo1.utilities

import Movie

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