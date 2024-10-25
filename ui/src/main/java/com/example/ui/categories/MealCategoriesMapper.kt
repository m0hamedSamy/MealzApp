package com.example.ui.categories

import com.example.domain.model.CategoryDomainModel

fun CategoryDomainModel.toUIModel(): CategoryUIModel = CategoryUIModel(
    id = id,
    name = name,
    description = description,
    imgUrl = imgUrl
)

fun List<CategoryDomainModel>.toUIModelList(): List<CategoryUIModel> = map { it.toUIModel() }