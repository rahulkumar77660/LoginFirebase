package com.example.loginfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splash_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splacsh)

        Handler().postDelayed({

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            finish()
        }, 2000)
    }
}