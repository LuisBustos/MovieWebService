package mx.com.gob.cdmx.webservice

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getMovieBreads(@Url url : String) : Response<MovieResponse>
}