package io.github.orizynpx.roomdbpractice.data.repository

import androidx.room.withTransaction
import io.github.orizynpx.roomdbpractice.data.model.Author
import io.github.orizynpx.roomdbpractice.data.model.Category
import io.github.orizynpx.roomdbpractice.data.model.PaperAuthorCrossRef
import io.github.orizynpx.roomdbpractice.data.model.ResearchPaper
import io.github.orizynpx.roomdbpractice.data.source.AppDatabase

class Repository(private val db: AppDatabase) {
    val allCategories = db.categoryDao().getAllCategories()
    val allAuthors = db.authorDao().getAllAuthors()
    val allPapersWithCategory = db.researchPaperDao().getAllPapersWithCategory()

    suspend fun insertCategory(c: Category) = db.categoryDao().insert(c)
    suspend fun insertAuthor(a: Author) = db.authorDao().insert(a)

    suspend fun insertPaperWithAuthors(p: ResearchPaper, authorIds: List<Long>) {
        db.withTransaction {
            val paperId = db.researchPaperDao().insert(p)
            authorIds.forEach { authorId ->
                db.researchPaperDao().insertPaperAuthorCrossRef(
                    PaperAuthorCrossRef(paperId, authorId)
                )
            }
        }
    }
}
