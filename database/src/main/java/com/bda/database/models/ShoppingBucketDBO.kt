package com.bda.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "buckets")
data class ShoppingBucketDBO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Long = 0,

    @ColumnInfo("title")
    val title: String,

    @ColumnInfo("description")
    val description: String?,

    @ColumnInfo("updateAt")
    val updateAt: Date,

    @ColumnInfo("isHidden")
    val isHadden: Boolean,

    @ColumnInfo("totalCost")
    val totalCost: Long = 0,
)