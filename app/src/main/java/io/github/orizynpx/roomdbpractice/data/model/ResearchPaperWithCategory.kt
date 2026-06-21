package io.github.orizynpx.roomdbpractice.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class ResearchPaperWithCategory (
    @Embedded
    val paper: ResearchPaper,

    @Relation(
        parentColumn = "categoryId",
        entityColumn = "Id"
    )
    val category: Category
)