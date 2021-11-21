package com.example.tiptime

import java.text.NumberFormat

class TipCalculator(val costOfService: Double?, val percentageTip: Double, val roundTip: Boolean) {

   val estaVariableSePuedeAccederEnTodosLosMetodosyDesdeAfueraConUnaInstancia: Int = 0
   private val estaVariableSePuedeAccederEnTodosLosMetodosPeroNoDesdeAfuera: Int = 0

   fun calculateTip(): String {
      // Este metodo retorna un String que se llama variableFormateadaDeTipQueVoyARetornarPorElMetodo
      // pero no importa porque simepre return String

      val cost = costOfService

      if (cost == null) {
         return "0.0"
      }

      var tip = percentageTip * cost
      if (roundTip) {
         tip = kotlin.math.ceil(tip)
      }

      val variableFormateadaDeTipQueVoyARetornarPorElMetodo = NumberFormat.getCurrencyInstance().format(tip)
      return variableFormateadaDeTipQueVoyARetornarPorElMetodo

   }

   fun otrometodo() {
      // YO NO CONOZCO NINGUNA DE LAS VARIABLES QUE ESTA
      // EN EL METODO CALCULATETIP

      // YO SI CONOZCO TODAS LAS VARIABLES QUE ESTAN A NIVEL DE CLASE

   }

}