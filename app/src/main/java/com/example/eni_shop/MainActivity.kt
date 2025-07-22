package com.example.eni_shop

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.eni_shop.bo.Article
import com.example.eni_shop.repository.ArticleRepository
import com.example.eni_shop.ui.theme.ENISHOPTheme
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ENISHOPTheme {
                val repository = ArticleRepository()
                val article1 = repository.getArticle(2L)
                println("Article récupéré : $article1")
                val newArticle = Article(
                    id = 0L,
                    name = "Fauteuil",
                    description = "Fauteuil en cuir confortable",
                    price = 249.99,
                    urlImage = "url4",
                    category = "Mobilier",
                    date = Date()
                )
                val newId = repository.addArticle(newArticle)
                println("Nouvel article ajouté avec id : $newId")
                val article2 = repository.getArticle(newId)
                println("Article inséré : $article2")
            }
        }
    }
}
