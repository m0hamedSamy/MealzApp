package com.example.mealzapp.di

import com.example.data.data_source.remote.MealsApi
import com.example.data.data_source.remote.MealsRemoteDataSource
import com.example.data.data_source.remote.MealsRemoteDataSourceImpl
import com.example.data.data_source.remote.RetrofitFactory
import com.example.data.repo.MealsRepositoryImpl
import com.example.domain.repo.MealsRepository
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val appModule = module {
    single {
        RetrofitFactory.createService(MealsApi::class.java)
    }
    single<MealsRemoteDataSource> {
        MealsRemoteDataSourceImpl(get())
    }
    single<MealsRepository> {
        MealsRepositoryImpl(get())
    }
    single {
        Dispatchers.IO
    }
}