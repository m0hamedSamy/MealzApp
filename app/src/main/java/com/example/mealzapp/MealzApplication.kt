package com.example.mealzapp

import android.app.Application
import com.example.mealzapp.di.mealzModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MealzApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MealzApplication)
            modules(mealzModules)
        }
    }
}