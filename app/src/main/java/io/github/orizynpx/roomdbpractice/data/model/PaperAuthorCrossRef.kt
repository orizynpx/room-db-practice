package io.github.orizynpx.roomdbpractice.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "paper_author_cross_ref",
    primaryKeys = ["paperId", "authorId"],
    foreignKeys = [
        ForeignKey(
            entity = ResearchPaper::class,
            parentColumns = ["paperId"],
            childColumns = ["paperId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Author::class,
            parentColumns = ["authorId"],
            childColumns = ["authorId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("paperId"), Index("authorId")]
)
data class PaperAuthorCrossRef(
    val paperId: Long,
    val authorId: Long
)
