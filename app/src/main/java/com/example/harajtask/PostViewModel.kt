package com.example.harajtask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.harajtask.data.Post
import com.example.harajtask.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor (private val repo:Repository) :ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    val postsLiveData:LiveData<List<Post>>
    get() = _posts
    init {
        _posts.value = repo.getPostsFromAssets()
    }


}