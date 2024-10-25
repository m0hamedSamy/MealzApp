package com.example.ui.categories

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_case.GetAllCategoriesUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CategoriesViewModel(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    init {
        fetchAllCategories()
    }

    private val _categoriesState = mutableStateOf(CategoriesUIState())
    val categoriesState: State<CategoriesUIState> = _categoriesState

    private fun fetchAllCategories() {
        viewModelScope.launch(ioDispatcher) {
            val result = getAllCategoriesUseCase()
            delay(1000)
            _categoriesState.value = _categoriesState.value.copy(
                isLoading = false,
                categories = result.toUIModelList()
            )
        }
    }
}