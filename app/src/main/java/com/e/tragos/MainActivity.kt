package com.e.tragos

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DrinksAdapter
    private var  ListaDetragos= listOf<Drinks>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)
        adapter= DrinksAdapter()
        recyclerView.adapter=adapter
        getRetrofit()
        getDrinkList()

    }

    private fun getDrinkList() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(ApiService::class.java).getTragos()
            val response= call.body()
            runOnUiThread {
                if (call.isSuccessful){
                   response?.apply { ListaDetragos= this.drinks }
                    adapter.submitList(ListaDetragos)


                }
            }
        }
    }


    private fun getRetrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


    companion object{
        val URL="https://www.thecocktaildb.com/api/json/v1/1/"
    }
}