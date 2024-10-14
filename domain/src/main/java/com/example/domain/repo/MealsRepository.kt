package com.example.domain.repo

import com.example.domain.model.CategoryDomainModel

interface MealsRepository {
    suspend fun getAllCategories(): List<CategoryDomainModel>
}