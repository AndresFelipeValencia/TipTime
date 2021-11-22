package com.example.tiptime

import android.content.Context
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.text.NumberFormat

class TipCalculator(val costOfService: Double?, val percentageTip: Double, val roundTip: Boolean) {

   fun calculateTip(): String {
      // Este metodo retorna un String que se llama variableFormateadaDeTipQueVoyARetornarPorElMetodo
      // pero no importa porque simepre return String

      val cost = costOfService ?: return "0.0"

      var tip = percentageTip * cost
      if (roundTip) {
         tip = kotlin.math.ceil(tip)
      }

      val variableFormateadaDeTipQueVoyARetornarPorElMetodo = NumberFormat.getCurrencyInstance().format(tip)
      return variableFormateadaDeTipQueVoyARetornarPorElMetodo

   }


}