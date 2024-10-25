package com.example.mealzapp.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Categories : Screen
}