package io.github.orizynpx.roomdbpractice.data.source

import androidx.room.*
import io.github.orizynpx.roomdbpractice.data.model.ResearchPaper
import io.github.orizynpx.roomdbpractice.data.model.ResearchPaperWithCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface ResearchPaperDao {
    @Insert
    suspend fun insert(paper: ResearchPaper): Long

    @Update
    suspend fun update(paper: ResearchPaper)

    @Delete
    suspend fun delete(paper: ResearchPaper)

    @Transaction
    @Query("SELECT * FROM papers")
    fun getAllPapersWithCategory(): Flow<List<ResearchPaperWithCategory>>

    @Transaction
    @Query("SELECT * FROM papers WHERE categoryId = :categoryId")
    fun getPapersByCategory(categoryId: Long): Flow<List<ResearchPaperWithCategory>>
}
