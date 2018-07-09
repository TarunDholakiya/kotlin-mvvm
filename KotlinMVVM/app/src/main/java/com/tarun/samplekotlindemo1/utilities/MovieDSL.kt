package com.tarun.samplekotlindemo1.utilities

import Movie
import MovieStore

fun movie(block: Movie.() -> Unit): Movie {
    val m = Movie()
    m.block()
    return m
}

fun moviestore(movieStoreBlock: MovieStore.() -> Unit): MovieStore {
    val m = MovieStore()
    m.movieStoreBlock()
    return m
}