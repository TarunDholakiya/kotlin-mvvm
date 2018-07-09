package com.tarun.samplekotlindemo1.view.adapter

import android.app.Activity
import android.content.Context
import android.graphics.Movie
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.tarun.samplekotlindemo1.R

class MovieAdapter(activity: Activity, private val items: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {
    private var context: Context = activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie, parent, false)
        return MovieHolder(v)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val item = items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}