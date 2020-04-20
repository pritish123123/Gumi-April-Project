package com.example.gumivietnam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button

class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT:Long=2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))

            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)

    }
}
