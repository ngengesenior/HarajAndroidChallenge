package com.example.harajtask.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    val title:String,
    val username:String,
    val thumbURL:String,
    val commentCount:Int?,
    val date:Long,
    val city:String,
    val body:String

):Parcelable