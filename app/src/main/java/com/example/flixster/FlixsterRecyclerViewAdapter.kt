package com.example.flixster

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.Glide


class FlixsterRecyclerViewAdapter(
    private val movies: List<Flixster>,
    private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<FlixsterRecyclerViewAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_flixster, parent, false)
        return MovieViewHolder(view)
    }
    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: Flixster? = null
        val mMovieTitle: TextView = mView.findViewById(R.id.movie_title)
        val mMovieImage: ImageView = mView.findViewById(R.id.movie_image)
        val mMovieOverview: TextView = mView.findViewById(R.id.movie_description)

        override fun toString(): String {
            return "${mMovieTitle.text}"
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val Allmovies = movies[position]

        holder.mItem = Allmovies
        holder.mMovieTitle.text = Allmovies.title
        holder.mMovieOverview.text = Allmovies.description

        Glide.with(holder.mView).load(Allmovies.ImageUrl).into(holder.mMovieImage)
        Allmovies.ImageUrl?.let { Log.d("ImageUrl", it)}

        holder.mView.setOnClickListener{
            holder.mItem?.let { Allmovies -> mListener?.onItemClick(Allmovies)}
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
    }