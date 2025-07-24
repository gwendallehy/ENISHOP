package com.example.eni_shop.ui.screen

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eni_shop.repository.ArticleRepository
import com.example.eni_shop.ui.common.EniShopTopBar
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuAnchorType
import androidx.compose.ui.platform.LocalContext

@Composable
fun ArticleCreateScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { EniShopTopBar() }
    ) {
        ArticleCreate(modifier = Modifier.padding(it))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleCreate(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var titre: String by rememberSaveable { mutableStateOf("") }
        var description: String by rememberSaveable { mutableStateOf("") }
        var prix by rememberSaveable { mutableStateOf("") }
        var categorie : String by rememberSaveable { mutableStateOf("") }

        TextField(

            modifier = Modifier.fillMaxWidth(),
            value = titre,
            onValueChange = {
                titre = it
            },
            label = { Text(text = "Titre") },
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = description,
            onValueChange = {
                description = it
            },
            label = { Text(text = "Description") },
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = prix,
            onValueChange = {
                prix = it
            },
            label = { Text(text = "Prix") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        val categories = listOf("electronics", "jewelery", "men's clothing", "women's clothing")
        DropDownExecutor(categories)

        val context = LocalContext.current
        Button(
            onClick = {
               Toast.makeText(context,"Article enregistré !", Toast.LENGTH_LONG).show()
            }
        ) {
            Text(text = "Enregistrer")
        }
    }
}


@Preview
@Composable
fun Preview() {
    ArticleCreate()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownExecutor(
    categories: List<String>
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    var selectedIndex by rememberSaveable { mutableStateOf(-1) }
    val selectedCategory = if (selectedIndex >= 0) categories[selectedIndex] else ""

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {

        TextField(
            value = selectedCategory,
            onValueChange = {},
            readOnly = true,
            label = { Text("Sélectionner une catégorie") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier.fillMaxWidth().menuAnchor(MenuAnchorType.PrimaryEditable, true)
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            categories.forEachIndexed { index, category ->
                DropdownMenuItem(
                    text = { Text(category) },
                    onClick = {
                        selectedIndex = index
                        expanded = false
                    }
                )
            }
        }
    }
}