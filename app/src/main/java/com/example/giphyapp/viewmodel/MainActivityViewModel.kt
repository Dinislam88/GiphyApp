package com.example.giphyapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.giphyapp.data.Data
import com.example.giphyapp.data.DataObject
import com.example.giphyapp.data.DataResult
import com.example.giphyapp.data.DataX
import com.example.giphyapp.model.repository.GiphyRepository
import com.example.giphyapp.model.repository.GiphyRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel {

    private val _gifs = MutableLiveData<List<Data?>>()
    val gifs : MutableLiveData<List<Data?>> = _gifs

    private val _gifDetails = MutableLiveData<List<DataX>>()
    val gifDetails: LiveData<List<DataX>> = _gifDetails

    private val mGiphyRepository: GiphyRepository = GiphyRepositoryImpl()

    fun getGifs() {
        val response = mGiphyRepository.getGifs()
        response.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>?, response: Response<Data>?) {
                Log.d("testLogs", "OnResponse Success ${call.toString()}")
                if (response != null) {
                    _gifs.postValue(listOf(response.body()))
                }
            }

            override fun onFailure(call: Call<Data>?, t: Throwable?) {
                Log.d("testLogs", "onFailure :  ${t?.message}")
            }
        })
    }

    fun getGifDetails(id: Int) {
        val response = mGiphyRepository.getGifDetails(id)
        response.enqueue(object : Callback<DataX> {
            override fun onResponse(call: Call<DataX>?, response: Response<DataX>?) {
                Log.d("testLogs", "onResponse Succes ${call.toString()}")
                if (response != null) {
                    _gifDetails.postValue(response?.body())
                }

            }

            override fun onFailure(call: Call<DataX>?, t: Throwable?) {
                Log.d("testLogs", "onFailure :  ${t?.message}")

            }
        })
    }
}