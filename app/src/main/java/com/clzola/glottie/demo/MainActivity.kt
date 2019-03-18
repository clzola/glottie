package com.clzola.glottie.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.clzola.glottie.GlottieView
import com.clzola.glottie.GlottieViewTarget

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val glottie = findViewById<GlottieView>(R.id.image)

        /**
         * Photo by Nathan Dumlao {@link https://unsplash.com/photos/71u2fOofI-U}
         * on Unsplash.com {@link https://unsplash.com}
         */
        GlideApp.with(this)
            .load("https://images.unsplash.com/photo-1510972527921-ce03766a1cf1?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80")
            .error(R.drawable.error)
            .into(GlottieViewTarget(glottie))
    }
}
