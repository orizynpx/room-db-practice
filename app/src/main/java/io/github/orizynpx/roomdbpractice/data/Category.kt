package io.github.orizynpx.roomdbpractice.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Entity(tableName = "categories")
data class Category @OptIn(ExperimentalUuidApi::class) constructor(
    @PrimaryKey(autoGenerate = true) val categoryId: Uuid,
    val name: String
)
