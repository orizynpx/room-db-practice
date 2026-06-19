@file:OptIn(ExperimentalUuidApi::class)

package io.github.orizynpx.roomdbpractice.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Entity(
    tableName = "papers",
    foreignKeys = [ForeignKey(
        entity = Category::class,
        parentColumns = ["categoryId"],
        childColumns = ["paperCategoryId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ResearchPaper(
    @PrimaryKey(autoGenerate = true) val paperId: Uuid,
    val title: String,
    val doi: String,
    val paperCategoryId: Uuid
)
