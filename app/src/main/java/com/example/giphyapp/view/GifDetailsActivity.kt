package com.example.giphyapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.giphyapp.R
import com.example.giphyapp.data.DataX
import com.example.giphyapp.viewmodel.MainActivityViewModel

class GifDetailsActivity : AppCompatActivity() {
    private val mViewModel: MainActivityViewModel = MainActivityViewModel()

    private lateinit var mImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gif_details)
        val id = intent.getIntExtra("id", 0)
        initViews()
        initObservers()
        mViewModel.getGifDetails(id)

    }

    private fun initObservers() {
        mViewModel.apply {
            gifDetails.observe(this@GifDetailsActivity){
                setGifInformation(it)

            }
        }
    }

    private fun setGifInformation(gifDetails: List<DataX>) {
        Glide.with(this)
            .load("https://media.giphy.com/media/")  // Call your GIF here (url, raw, etc.)
            .into(mImageView)
    }

    private fun initViews() {
        mImageView = findViewById(R.id.imageView)
    }
}