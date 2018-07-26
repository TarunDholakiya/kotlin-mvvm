package com.tarun.samplekotlindemo1.view.ui

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tarun.samplekotlindemo1.R
import com.tarun.samplekotlindemo1.rest.Outcome
import com.tarun.samplekotlindemo1.utilities.toast
import com.tarun.samplekotlindemo1.viewmodel.MovieListViewModel
import com.tarun.samplekotlindemo1.viewmodel.MovieListViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var activity: Activity

    lateinit var viewModelFactory: MovieListViewModelFactory
    private val viewModel: MovieListViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MovieListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activity = this
        initiateDataListener()
    }

    private fun initiateDataListener() {
        viewModel.moviesOutcome.observe(this, Observer { t ->
            when (t) {
                is Outcome.Progress -> activity.toast("Prpgress !!!")
                is Outcome.Success -> activity.toast("Success !!!")
                is Outcome.Failure -> activity.toast("Failure !!!")
            }
        })
    }
}