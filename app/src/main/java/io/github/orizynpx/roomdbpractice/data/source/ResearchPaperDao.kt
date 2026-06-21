package io.github.orizynpx.roomdbpractice.data.source

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import io.github.orizynpx.roomdbpractice.data.model.ResearchPaperWithCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface ResearchPaperDao {
    @Transaction
    @Query("SELECT * FROM papers")
    fun getAllPapersWithCategories(): Flow<List<ResearchPaperWithCategory>>

    @Transaction
    @Query("SELECT * FROM papers WHERE categoryId = :catId")
    fun getPapersByCategory(catId: String): Flow<List<ResearchPaperWithCategory>>
}