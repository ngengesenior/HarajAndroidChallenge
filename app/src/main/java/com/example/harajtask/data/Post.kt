package com.example.harajtask.data

data class Post(
    val title:String,
    val username:String,
    val thumbURL:String,
    val commentCount:Int,
    val date:Long,
    val city:String,
    val body:String

)