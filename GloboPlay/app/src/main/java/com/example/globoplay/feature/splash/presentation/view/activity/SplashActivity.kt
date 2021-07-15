@file:Suppress("DEPRECATION")

package com.example.globoplay.feature.splash.presentation.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.globoplay.R
import com.example.globoplay.databinding.ActivityMovielistBinding
import com.example.globoplay.databinding.ActivitySplashBinding
import com.example.globoplay.feature.film.presentation.view.activity.MovieListActivity

class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupActionBar()
        Handler().postDelayed(
            {
                val i = Intent(this@SplashActivity, MovieListActivity::class.java)
                startActivity(i)
                finish()
            }, 3000L
        )
    }

    private fun setupActionBar() {
        supportActionBar?.hide()
    }
}