package com.example.mealzapp.di

import org.koin.dsl.module

val mealzModules = module {
    includes(
        appModule,
        mealCategoriesModule
    )
}