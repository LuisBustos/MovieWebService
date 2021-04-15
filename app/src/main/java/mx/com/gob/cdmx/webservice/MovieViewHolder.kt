package mx.com.gob.cdmx.webservice

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mx.com.gob.cdmx.webservice.databinding.MovieviewBinding

class MovieViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    private val binding = MovieviewBinding.bind(view)
    fun bind(movie:Movie){
        binding.idMovie.text = movie.id.toString() ?: "0"
            binding.idDirector.text = movie.director ?: "No tiene director"
            binding.genre.text = movie.genero ?: "Desconocido"
            Picasso.get().load(movie.poster).into(binding.poster)
    }
}