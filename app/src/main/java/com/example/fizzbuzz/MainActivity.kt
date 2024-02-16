package com.example.fizzbuzz

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
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
        helpWhatIsFizzBuzz()
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
            number % 3 == 0 && number % 5 == 0 -> "O número: $number é FizzBuzz."
            number % 3 == 0 -> "O número: $number é Fizz."
            number % 5 == 0 -> "O número: $number é Buzz."
            else -> "O número: $number não é FizzBuzz."
        }
    }

    private fun helpWhatIsFizzBuzz() {
        binding.imageViewHelp.setOnClickListener {
            dialogAboutFizzBuzz()
        }
    }

    private fun dialogAboutFizzBuzz() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_layout_about_fizz_buzz)
        val closeDialog = dialog.findViewById<Button>(R.id.button_close_dialog)
        closeDialog.setOnClickListener {
            dialog.dismiss()
        }
        dialog.setCancelable(false)
        dialog.show()
    }


    private fun View.hideKeyBord() {
        val inputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(this.windowToken, 0)
    }
}