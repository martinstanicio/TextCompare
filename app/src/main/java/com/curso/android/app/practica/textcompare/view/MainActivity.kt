package com.curso.android.app.practica.textcompare.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.practica.textcompare.R
import com.curso.android.app.practica.textcompare.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.result.observe(this) {
            binding.result.text =
                if (it.result) getString(R.string.result_positive) else getString(R.string.result_negative)
            binding.timestamp.text = "${getString(R.string.timestamp)}: ${it.timestamp}"
        }

        binding.compareButton.setOnClickListener {
            val text1 = binding.text1.text.toString()
            val text2 = binding.text2.text.toString()

            mainViewModel.makeTextComparison(text1, text2)
        }
    }
}
