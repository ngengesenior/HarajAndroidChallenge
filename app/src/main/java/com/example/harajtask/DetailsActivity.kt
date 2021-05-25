package com.example.harajtask

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.harajtask.Utils.createShareIntent
import com.example.harajtask.data.Post
import com.example.harajtask.databinding.ActivityDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        supportActionBar?.hide()
        val post = intent.getParcelableExtra<Post>("post")
        val binding:ActivityDetailsBinding = DataBindingUtil.setContentView(this,R.layout.activity_details)
        binding.post = post
        binding.toolbar.setNavigationOnClickListener {
            Log.d(TAG, "onCreate: It was clicled")
            this.createShareIntent(post!!.title)

        }
        binding.executePendingBindings()

    }
}