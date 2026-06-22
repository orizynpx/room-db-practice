package io.github.orizynpx.roomdbpractice.data.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class ResearchPaperWithCategory(
    @Embedded val paper: ResearchPaper,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "categoryId"
    )
    val category: Category,
    @Relation(
        parentColumn = "paperId",
        entityColumn = "authorId",
        associateBy = Junction(PaperAuthorCrossRef::class)
    )
    val authors: List<Author>
)
