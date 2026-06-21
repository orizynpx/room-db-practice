package io.github.orizynpx.roomdbpractice.data.source

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface CategoryDao {
    @Transaction
    @Query("SELECT * FROM categories")
    fun getAllCategories()
}