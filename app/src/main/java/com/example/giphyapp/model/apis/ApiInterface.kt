package com.example.giphyapp.model.apis

import com.example.giphyapp.data.Data
import com.example.giphyapp.data.DataResult
import com.example.giphyapp.data.DataX
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("v1/gifs/trending")
    fun getGifs(
        @Query("api_key") sort: String,
        @Query("limit") limit: Int,
        @Query("rating") rating: String
    ): Call<Data>

    @GET("v1/gifs/trending/{gif_id}")
    fun getGifDetails(
        @Path("gif_id") gifId: String,
        @Query("api_key") sort: String,
    ): Call<DataX>


    companion object {

        var BASE_URL = "https://api.giphy.com/"

        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}