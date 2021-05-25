package com.example.harajtask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.OrientationHelper.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

const val TAG = "MainTag"
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: PostViewModel by viewModels()
    lateinit var adapter: PostsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        adapter = PostsListAdapter {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("post", it)
            startActivity(intent)
        }

        binding.postRecyclerview.addItemDecoration(DividerItemDecoration(this,VERTICAL))
        binding.postRecyclerview.adapter = adapter

        viewModel.postsLiveData.observe(this, Observer {
            adapter.submitList(it)
        })


    }
}