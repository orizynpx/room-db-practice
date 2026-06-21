@file:OptIn(ExperimentalUuidApi::class)

package io.github.orizynpx.roomdbpractice.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Entity(tableName = "papers")
data class ResearchPaper(
    @PrimaryKey(autoGenerate = true) val paperId: Uuid,
    val title: String,
    val abstract: String,
    val categoryId: Uuid
)
