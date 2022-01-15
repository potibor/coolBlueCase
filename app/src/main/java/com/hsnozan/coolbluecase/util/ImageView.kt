package com.hsnozan.coolbluecase.util

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by hsnozan on 15.01.2022.
 */

fun ImageView.load(url: String?) {
    Glide.with(context)
        .load(url)
        .into(this)
}