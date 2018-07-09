package com.tarun.samplekotlindemo1.view.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tarun.samplekotlindemo1.R
import com.tarun.samplekotlindemo1.rest.ApiClient.Companion.getMovieService
import com.tarun.samplekotlindemo1.rest.ConnectivityInterceptor
import com.tarun.samplekotlindemo1.utilities.movie
import com.tarun.samplekotlindemo1.utilities.moviestore
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*val movies = FileUtils.getMoviesFromCsv("D:\\MovieList.csv")
        movies.forEach { movie -> println(get("http://omdbapi.com/?apikey=1277cc5b&i=${movie.id}").text) }
        movies.getMoviesByReleaseYear(19    92)*/
        //println(get("http://omdbapi.com/?apikey=1277cc5b&i=tt0068646").text)
        getMovieService(this).getMovieDetails("tt006846")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ movieDetail ->
                    tvTitle.text = movieDetail.title

                }, { throwable ->
                    if (throwable is ConnectivityInterceptor.NoConnectivityException) {
                    }
                })

        val movies = moviestore {

            movie {
                id = "1"
                name = "Tarun"
                stars = listOf("a", "b")
                directors = listOf("dir1", "dir2")
                releaseYear = 1993
            }
            movie {
                id = "2"
                name = "Tarun 2 "
                stars = listOf("a", "b")
                directors = listOf("dir1", "dir2")
                releaseYear = 1994
            }

        }

        print(movies)
    }
}