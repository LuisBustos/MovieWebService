package mx.com.gob.cdmx.webservice

import com.google.gson.annotations.SerializedName


data class MovieResponse(
    @SerializedName("peliculas") var movies : List<Movie>
)