package com.example.mealzapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ui.categories.CategoriesScreen
import com.example.ui.categories.CategoriesViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MealzApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Categories) {
        composable<Screen.Categories> {
            val viewModel: CategoriesViewModel = koinViewModel()
            CategoriesScreen(
                state = viewModel.categoriesState.value
            )
        }
    }
}