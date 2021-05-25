package com.example.harajtask

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object Utils {
    private val outputDateFormat: DateFormat = SimpleDateFormat("MMMM dd, yyyy")

    fun formatDate(dateLong: Long): String = outputDateFormat.format(Date(dateLong))

    fun Context.createShareIntent(title: String) {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, title)
            type = "text/plain"
        }
        startActivity(shareIntent)

    }
}

@BindingAdapter("image")
fun bindImage(imageView: ImageView,url:String) = Glide.with(imageView)
    .load(url)
    .error(R.drawable.ic_launcher_background)
    .into(imageView)

@BindingAdapter("car")
fun bindCar(textView: TextView,car:String){
    textView.text = "I have a $car"
}


@BindingAdapter("sale")
fun bindLocation(textView: TextView,city:String) {
    textView.text = "For sale in $city"
}
@BindingAdapter("date")
fun bindDate(textView: TextView,dateLong: Long){
    textView.text = Utils.formatDate(dateLong)
}

