package com.example.capstoneproject.common

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.downloadImage(imageURL: String){
    Glide.with(this.context).load(imageURL).into(this)
}