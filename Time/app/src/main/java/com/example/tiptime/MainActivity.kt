package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {

        val stringIntTextField = binding.costOfService.text.toString()
        val cost = stringIntTextField.toDoubleOrNull()

        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        val roundUp = binding.roundUpSwitch.isChecked

        val tipCalculator = TipCalculator(cost, tipPercentage, roundUp)
        val tip = tipCalculator.calculateTip()
        // Aqui estoy llamando el metodo de la instancia tipcalculater que retorna un String
        // y lo almaceno en la variable String llamada tip

        binding.tipResult.text = getString(R.string.tip_amount, tip)

    }

}