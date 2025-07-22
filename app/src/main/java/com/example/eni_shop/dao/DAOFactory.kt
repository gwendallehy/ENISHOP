package com.example.eni_shop.dao

import com.example.eni_shop.dao.memory.ArticleDAOMemoryImpl

abstract class DAOFactory {

    companion object {
        fun createArticleDAO(type: DAOType): ArticleDAO {
            return when (type) {
                DAOType.MEMORY -> ArticleDAOMemoryImpl()
                DAOType.NETWORK -> throw NotImplementedError("Network DAO not implemented yet")
            }
        }
    }
}
