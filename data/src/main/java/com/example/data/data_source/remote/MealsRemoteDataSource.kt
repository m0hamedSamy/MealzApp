package com.example.data.data_source.remote

import com.example.data.model.CategoryDataModel

interface MealsRemoteDataSource {
    suspend fun getAllCategories(): List<CategoryDataModel>
}