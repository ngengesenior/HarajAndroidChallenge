package com.example.harajtask.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.IOException
import javax.inject.Inject

class Repository @Inject constructor( @ApplicationContext private val context: Context,private val gson: Gson) {

    fun getPostsFromAssets():List<Post> {
        val posts = mutableListOf<Post>()

        try {
            // read json string from assets
            val jsonString = context.assets.open("data.json").bufferedReader().use { it.readText() }
            val listPostType = object : TypeToken<List<Post>>() {}.type
            val allPosts:List<Post> = gson.fromJson(jsonString,listPostType)
            posts.addAll(allPosts)
            
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return emptyList()
        }
        return posts

    }
}