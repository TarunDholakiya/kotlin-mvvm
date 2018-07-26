package com.tarun.samplekotlindemo1.model.apiservices

import MovieDetails
import com.tarun.samplekotlindemo1.rest.Outcome
import io.reactivex.Flowable
import io.reactivex.subjects.PublishSubject

interface MovieListDataContract {
    interface Repository {
        val moviesFetchOutcome: PublishSubject<Outcome<List<MovieDetails>>>
        fun fetchMovies()
        fun refreshMovies()
        fun handleError(error: Throwable)
    }

    interface Local {
        fun getPostsWithUsers(): Flowable<List<MovieDetails>>
        //fun saveUsersAndPosts(users: List<User>, posts: List<Post>)
    }

    interface Remote {
        //fun getUsers(): Single<List<User>>
        //fun getPosts(): Single<List<Post>>
    }
}