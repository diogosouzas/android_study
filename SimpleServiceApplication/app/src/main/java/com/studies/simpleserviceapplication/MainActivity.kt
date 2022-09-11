package com.studies.simpleserviceapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.studies.simpleserviceapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnStartService.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                binding.tvStatusService.text = getString(R.string.service_running)
            }
        }
    }
}