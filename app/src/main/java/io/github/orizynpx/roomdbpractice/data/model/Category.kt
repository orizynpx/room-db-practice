@file:OptIn(ExperimentalUuidApi::class)

package io.github.orizynpx.roomdbpractice.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true) val categoryId: Uuid,
    val name: String
)
