package com.example.nationalparks.util

import android.content.ContentResolver
import android.net.Uri
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.nationalparks.R
import com.squareup.picasso.Picasso

@BindingAdapter("app:imageUrl")
fun loadImageUrl(imageView: ImageView, url: String?) {
    if (url != "") {
        Picasso.get().load(url).into(imageView)
    }
}

@BindingAdapter("app:drawableUri")
fun loadImageDrawable(imageView: ImageView, drawableName: String?) {
    if (drawableName != "") {
        val context = imageView.context
        val builder = Uri.Builder()
        val uri = builder.apply {
            scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
            authority(context.resources.getResourcePackageName(R.drawable.rain))
            appendPath(context.resources.getResourceTypeName(R.drawable.rain))
            appendPath("com.example.nationalparks:drawable/$drawableName")
        }.build()
        Picasso.get().load(uri).into(imageView)
    }
}