package com.example.data.data_source.remote

import com.example.data.model.CategoriesResponseModel
import retrofit2.http.GET

interface MealsApi {

    companion object {
        const val ALL_CATEGORIES = "categories.php"
    }

    @GET(ALL_CATEGORIES)
    suspend fun getAllCategories(): CategoriesResponseModel
}