package com.example.tebakgambar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tebakgambar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logoLine.setOnClickListener {
            val logo = Logo(R.drawable.line, "Line")
            startTebakActivity(logo)
        }
        binding.logoIg.setOnClickListener {
            val logo = Logo(R.drawable.instagram, "Instagram")
            startTebakActivity(logo)
        }
        binding.logoYt.setOnClickListener {
            val logo = Logo(R.drawable.youtube, "Youtube")
            startTebakActivity(logo)
        }
        binding.logoWa.setOnClickListener {
            val logo = Logo(R.drawable.whatsapp, "Whatsapp")
            startTebakActivity(logo)
        }
        binding.logoSnapchat.setOnClickListener {
            val logo = Logo(R.drawable.snapchat, "Snapchat")
            startTebakActivity(logo)
        }
        binding.logoTwitter.setOnClickListener {
            val logo = Logo(R.drawable.twitter, "Twitter")
            startTebakActivity(logo)
        }
    }

    private fun startTebakActivity(logo: Logo) {
        val intent = Intent(this, TebakActivity::class.java)
        intent.putExtra("logo", logo)
        startActivity(intent)
    }
}