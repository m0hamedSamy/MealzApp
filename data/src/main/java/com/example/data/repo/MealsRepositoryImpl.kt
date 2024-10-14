package com.example.data.repo

import com.example.data.data_source.remote.MealsRemoteDataSource
import com.example.data.mapper.toDomainModelList
import com.example.domain.model.CategoryDomainModel
import com.example.domain.repo.MealsRepository

class MealsRepositoryImpl(private val remoteDataSource: MealsRemoteDataSource) : MealsRepository{
    override suspend fun getAllCategories(): List<CategoryDomainModel> {
        return remoteDataSource.getAllCategories().toDomainModelList()
    }
}