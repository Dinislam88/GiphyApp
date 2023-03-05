package com.example.giphyapp.data

import java.io.Serializable

data class Data(
    val `data`: List<DataX>,
    val meta: Meta,
    val pagination: Pagination
): Serializable