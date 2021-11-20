package com.example.tiptime

import java.text.NumberFormat

class TipCalculator(val costOfService: Double?, val percentageTip: Double, val roundTip: Boolean) {

   fun calculateTip(): String {

      val cost = costOfService

      if (cost == null) {
         return "0.0"
      }

      var tip = percentageTip * cost
      if (roundTip) {
         tip = kotlin.math.ceil(tip)
      }

      val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
      return formattedTip

   }

}