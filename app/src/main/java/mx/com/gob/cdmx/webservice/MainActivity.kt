package mx.com.gob.cdmx.webservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.motion.widget.Debug
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mx.com.gob.cdmx.webservice.databinding.ActivityMainBinding
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter
    private val moviesMutableList = mutableListOf<Movie>()
    val url="http://demo1898150.mockable.io/"

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        searchMovies()
        initRecyclerView()
    }


    private fun initRecyclerView(){
        adapter = MovieAdapter(moviesMutableList)
        binding.rvMovie.layoutManager = LinearLayoutManager(this)
        binding.rvMovie.adapter = adapter
    }

    private fun getRetrofit (): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchMovies(){
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<MovieResponse> = getRetrofit().create(APIService::class.java).getMovieBreads(url+"peliculas")
            val movieQuery:MovieResponse? = call.body()
            Debug.logStack("Movies","message: " + movieQuery!!.movies.toString(), 1)
            runOnUiThread{
                if(call.isSuccessful){
                    val movieList:List<Movie> = movieQuery?.movies ?: emptyList()
                    moviesMutableList.clear()
                    moviesMutableList.addAll(movieList)
                    adapter.notifyDataSetChanged()
                }   else{
                    showError()
                }
            }
        }
    }

    private fun showError(){
        Toast.makeText(this,"Error", Toast.LENGTH_LONG).show()
    }

}