package com.example.tugasmobile

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugasmobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.github.setOnClickListener {
            val git = Intent(Intent.ACTION_VIEW)
            git.setData(Uri.parse("https:github.com"))
            startActivity(git)
        }


        binding.parsing.setOnClickListener{
            val masukParsing = Intent(this@MainActivity, Profile::class.java)
            startActivity(masukParsing)
        }

        binding.keluar.setOnClickListener{
            finish();
            System.exit(0)
        }
        binding.profile.setOnClickListener{
            val masukProfile = Intent(this@MainActivity, Profile::class.java)
            startActivity(masukProfile)
        }
    }

}