package io.github.orizynpx.roomdbpractice.data.source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.orizynpx.roomdbpractice.data.model.Category
import io.github.orizynpx.roomdbpractice.data.model.ResearchPaper

@Database(
    entities = [ResearchPaper::class, Category::class],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun researchPaperDao(): ResearchPaperDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "papers_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}