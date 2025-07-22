//ArticleDao est une interface permettant de structurer l’envoi et la récupération de nos articles.
// Elle sera implémenter par tout les types de fournisseurs de données
package com.example.eni_shop.dao
import com.example.eni_shop.bo.Article

interface ArticleDAO {
    fun findById(id: Long): Article?
    fun insert(article: Article): Long
}