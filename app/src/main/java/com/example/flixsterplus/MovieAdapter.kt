package com.example.flixsterplus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/*
* can display a movie and make a call
* to the onlistfragmentinteraction listener
* */

class MovieAdapter(private val movies: List<Movie>, private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.fragment_movie, parent, false)
        return MovieViewHolder(view)
    }

    /**
     * inner class to refer to view elements in XML
     * */

    inner class MovieViewHolder(val mView: View): RecyclerView.ViewHolder(mView){
        var mItem: Movie? = null
        val mMovieTitle: TextView = mView.findViewById<View>(R.id.movie_title) as TextView
        val mMovieDescription: TextView = mView.findViewById<View>(R.id.movie_description) as TextView
        val mMovieImage: ImageView = mView.findViewById<View>(R.id.movie_image) as ImageView
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.mItem = movie
        holder.mMovieTitle.text = movie.title
        holder.mMovieDescription.text = movie.description

        holder.mView.setOnClickListener{
            holder.mItem?.let{ movie ->
                mListener?.onItemClick(movie)
            }
        }
        val fullImage: String = "https://image.tmdb.org/t/p/w500/" + movie.image
        Glide.with(holder.mView)
            .load(fullImage)
            .centerInside()
            .into(holder.mMovieImage)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

