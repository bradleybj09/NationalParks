package com.example.nationalparks.util

import android.content.ContentResolver
import android.net.Uri
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.nationalparks.R
import com.squareup.picasso.Picasso

@BindingAdapter("app:imageUrl")
fun loadImageUrl(imageView: ImageView, parkCode: String?) {
    if (parkCode != null && parkCode != "") {
        Log.e("imagePath",Util.API_PATH + "img/parks/" + parkCode.toLowerCase() + ".jpg")
        Picasso.get().load(Util.API_PATH + "img/parks/" + parkCode.toLowerCase() + ".jpg").into(imageView)
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