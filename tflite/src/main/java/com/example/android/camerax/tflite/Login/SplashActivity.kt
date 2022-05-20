package com.example.android.camerax.tflite.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.android.example.camerax.tflite.R
import com.example.android.camerax.tflite.CameraActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

    }
}