package com.example.giphyapp.model.repository

import com.example.giphyapp.data.Data
import com.example.giphyapp.data.DataResult
import com.example.giphyapp.data.DataX
import retrofit2.Call

interface GiphyRepository {

    fun getGifs(): Call<Data>

    fun getGifDetails(id: String): Call<DataX>

}