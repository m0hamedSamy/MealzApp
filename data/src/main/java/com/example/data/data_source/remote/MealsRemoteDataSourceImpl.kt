package com.example.data.data_source.remote

import com.example.data.model.CategoryDataModel

class MealsRemoteDataSourceImpl(private val api: MealsApi) : MealsRemoteDataSource {
    override suspend fun getAllCategories(): List<CategoryDataModel> {
        return api.getAllCategories().categories
    }
}