package io.github.orizynpx.roomdbpractice.data.source

import androidx.room.*
import io.github.orizynpx.roomdbpractice.data.model.Author
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthorDao {
    @Insert
    suspend fun insert(author: Author): Long

    @Update
    suspend fun update(author: Author)

    @Delete
    suspend fun delete(author: Author)

    @Query("SELECT * FROM authors")
    fun getAllAuthors(): Flow<List<Author>>
}
