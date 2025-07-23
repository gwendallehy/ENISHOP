package com.example.eni_shop.ui.common

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.toFrenchFormat() : String{
    val formatter = SimpleDateFormat("dd/MM/yyyy")
    return formatter.format(this)
}