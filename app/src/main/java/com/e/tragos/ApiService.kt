package com.e.tragos

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET
        (value= "filter.php?a=Alcoholic")
    suspend fun getTragos(): Response<DrinksResponse>
}

