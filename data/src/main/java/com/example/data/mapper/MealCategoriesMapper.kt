package com.example.data.mapper

import com.example.data.model.CategoryDataModel
import com.example.domain.model.CategoryDomainModel

fun CategoryDataModel.toDomainModel(): CategoryDomainModel = CategoryDomainModel(
    id = idCategory,
    name = strCategory,
    description = strCategoryDescription,
    imgUrl = strCategoryThumb
)

fun List<CategoryDataModel>.toDomainModelList(): List<CategoryDomainModel> = map { it.toDomainModel() }
