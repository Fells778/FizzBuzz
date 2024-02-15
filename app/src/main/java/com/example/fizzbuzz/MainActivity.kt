package com.example.fizzbuzz

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.view.isVisible
import com.example.fizzbuzz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        sendNumber()
    }

    private fun sendNumber() {
        binding.buttonSendNumber.setOnClickListener {
            it.hideKeyBord()
            resultFizzBuzz()
        }
    }

    private fun resultFizzBuzz() {
        binding.apply {
            textResult.isVisible = true
            textResult.text = verificationIsFizzBuzz(textNumber.text.toString().toInt())
        }
    }

    private fun verificationIsFizzBuzz(number: Int): String {
        return when {
            number % 3 == 0 && number % 5 == 0 -> "O $number é FizzBuzz"
            number % 3 == 0 -> "O $number é Fizz"
            number % 5 == 0 -> "O $number é Buzz"
            else -> "O $number não é FizzBuzz"
        }
    }


    private fun View.hideKeyBord() {
        val inputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(this.windowToken, 0)
    }
}