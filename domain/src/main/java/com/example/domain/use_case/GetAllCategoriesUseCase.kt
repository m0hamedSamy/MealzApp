package com.example.domain.use_case

import com.example.domain.model.CategoryDomainModel
import com.example.domain.repo.MealsRepository

class GetAllCategoriesUseCase(private val repo: MealsRepository) {
    suspend operator fun invoke(): List<CategoryDomainModel>{
        return repo.getAllCategories()
    }
}