package io.github.orizynpx.roomdbpractice.ui

import androidx.lifecycle.*
import io.github.orizynpx.roomdbpractice.data.model.Category
import io.github.orizynpx.roomdbpractice.data.model.ResearchPaper
import io.github.orizynpx.roomdbpractice.data.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repo: Repository) : ViewModel() {
    val categories = repo.allCategories.asLiveData()
    val papersWithCategory = repo.allPapersWithCategory.asLiveData()

    fun addCategory(name: String) = viewModelScope.launch {
        repo.insertCategory(Category(name = name))
    }

    fun addPaper(title: String, abstract: String, categoryId: Long) = viewModelScope.launch {
        repo.insertPaper(
            ResearchPaper(
                title = title,
                abstract = abstract,
                categoryId = categoryId
            )
        )
    }
}

class MainViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
