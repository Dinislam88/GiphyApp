package com.example.giphyapp.model.repository

import com.example.giphyapp.Constants
import com.example.giphyapp.data.Data
import com.example.giphyapp.data.DataObject
import com.example.giphyapp.data.DataResult
import com.example.giphyapp.data.DataX
import com.example.giphyapp.model.apis.ApiInterface
import retrofit2.Call

class GiphyRepositoryImpl : GiphyRepository {

    private val apiInterface = ApiInterface.create()

    override fun getGifs(): Call<Data> {
        return apiInterface.getGifs(Constants.APY_KEY, 25, "g")
    }

    override fun getGifDetails(id: String): Call<DataX> {
        return apiInterface.getGifDetails("gif_id", Constants.APY_KEY)
    }

}