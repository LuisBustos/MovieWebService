package mx.com.gob.cdmx.webservice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(val movies:List<Movie>) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.movieview,parent,false))
    }
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind( movies[position])
    }
    override fun getItemCount(): Int {
        return movies.size
    }
}