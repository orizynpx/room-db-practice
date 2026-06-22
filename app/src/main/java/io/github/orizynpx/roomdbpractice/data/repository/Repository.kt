package io.github.orizynpx.roomdbpractice.data.repository

import io.github.orizynpx.roomdbpractice.data.model.Category
import io.github.orizynpx.roomdbpractice.data.model.ResearchPaper
import io.github.orizynpx.roomdbpractice.data.source.AppDatabase

class Repository(private val db: AppDatabase) {
    val allCategories = db.categoryDao().getAllCategories()
    val allPapersWithCategory = db.researchPaperDao().getAllPapersWithCategory()

    suspend fun insertCategory(c: Category) = db.categoryDao().insert(c)
    suspend fun insertPaper(p: ResearchPaper) = db.researchPaperDao().insert(p)
}
