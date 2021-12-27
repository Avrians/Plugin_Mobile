package com.example.tugasmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugasmobile.databinding.ActivityParshingBinding
import com.example.tugasmobile.databinding.ActivityProfileBinding

class Parshing : AppCompatActivity() {
    private lateinit var binding: ActivityParshingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParshingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}