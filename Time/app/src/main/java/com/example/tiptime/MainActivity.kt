package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

/**
 * Activity that displays a tip calculator.
 */
class MainActivity : AppCompatActivity() {

    // Binding object instance with access to the views in the activity_main.xml layout
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout XML file and return a binding object instance
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Set the content view of the Activity to be the root view of the layout
        setContentView(binding.root)

        // Setup a click listener on the calculate button to calculate the tip
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {

        val stringIntTextField = binding.costOfServiceEditText.text.toString()
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