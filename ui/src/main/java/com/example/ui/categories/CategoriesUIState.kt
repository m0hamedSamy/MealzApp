package com.example.ui.categories

data class CategoriesUIState (
    val isLoading: Boolean = true,
    val categories: List<CategoryUIModel> = emptyList()
)