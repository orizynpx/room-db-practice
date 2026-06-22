package io.github.orizynpx.roomdbpractice.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "authors")
data class Author(
    @PrimaryKey(autoGenerate = true) val authorId: Long = 0L,
    val name: String,
    val affiliation: String
)
