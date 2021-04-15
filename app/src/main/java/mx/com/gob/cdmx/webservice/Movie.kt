package mx.com.gob.cdmx.webservice

import com.google.gson.annotations.SerializedName

class Movie (
    @SerializedName("id") var id : Int,
    @SerializedName("director") var director : String ,
    @SerializedName("duracion") var duracion : Int,
    @SerializedName("genero") var genero : String,
    @SerializedName("poster") var poster : String,
)