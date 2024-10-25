package com.example.mealzapp.di

import com.example.domain.use_case.GetAllCategoriesUseCase
import com.example.ui.categories.CategoriesViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val mealCategoriesModule = module {
    viewModel<CategoriesViewModel> {
        CategoriesViewModel(
            getAllCategoriesUseCase = get(),
            ioDispatcher = get()
        )
    }

    factory { GetAllCategoriesUseCase(get()) }
}