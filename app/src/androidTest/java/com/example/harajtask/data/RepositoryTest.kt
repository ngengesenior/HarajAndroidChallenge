package com.example.harajtask.data

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.Gson
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RepositoryTest{
    lateinit var gson: Gson
    lateinit var context: Context
    lateinit var  repo:Repository
    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        gson = Gson()
        repo = Repository(context,gson)
    }

    @Test
    fun testThatGetAssetsReturnsData() {
        val data = repo.getPostsFromAssets()
        assert(data.isNotEmpty())
        assert(data[0].commentCount != null)
    }
}