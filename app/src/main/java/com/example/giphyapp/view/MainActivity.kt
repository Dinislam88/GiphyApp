package com.example.giphyapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.giphyapp.R
import com.example.giphyapp.data.DataObject
import com.example.giphyapp.data.DataX
import com.example.giphyapp.view.adapters.CustomAdapter
import com.example.giphyapp.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity(), CustomAdapter.ItemClickListener {

    private val mViewModel: MainActivityViewModel = MainActivityViewModel()

    private lateinit var mGifsRecyclerView: RecyclerView
    private lateinit var mGifsAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initObservers()
        mViewModel.getGifs()
    }

    private fun initObservers() {
        mViewModel.apply {
            gifs.observe(this@MainActivity) {
                mGifsAdapter = CustomAdapter(it, this@MainActivity)
                mGifsRecyclerView.adapter = mGifsAdapter
            }
        }
    }

    private fun initViews() {
        mGifsRecyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        mGifsRecyclerView.layoutManager = GridLayoutManager(this, 2)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finishAffinity()
    }

    override fun onItemClick(position: List<DataX>) {
        val intent = Intent(this@MainActivity, GifDetailsActivity::class.java)
        intent.putExtra("id",position)
        startActivity(intent)
    }

}