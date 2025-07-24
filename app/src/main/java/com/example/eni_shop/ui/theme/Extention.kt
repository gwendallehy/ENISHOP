package com.example.eni_shop.ui.theme

import java.text.SimpleDateFormat
import java.util.Date

fun Date.toFrenchFormat() : String{
    val formatter = SimpleDateFormat("dd/MM/yyyy")
    return formatter.format(this)
}