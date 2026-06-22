package io.github.orizynpx.roomdbpractice.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "papers",
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["categoryId"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("categoryId")]
)
data class ResearchPaper(
    @PrimaryKey(autoGenerate = true) val paperId: Long = 0L,
    val title: String,
    val abstract: String,
    val categoryId: Long
)
