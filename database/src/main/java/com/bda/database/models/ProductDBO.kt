package com.bda.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "product")
data class ProductDBO(
    @PrimaryKey
    @ColumnInfo("id")
    val id: Long = 0,

    @ColumnInfo("name")
    val name: String,

    @ColumnInfo("description")
    val description: String,

    @ColumnInfo("isChecking")
    val isChecking: Boolean,

    @ColumnInfo("addedAt")
    val addedAt: Date,

    @ColumnInfo("unit")
    val unit: String, // единицы измерений(вес, штук и т.п.)

    @ColumnInfo("count")
    val count: Long,

    @ColumnInfo("price")
    val price: Long = 0,

    @ColumnInfo("image")
    val image: String,

    @ColumnInfo("ownerBucketsId")
    val ownerBucketsId: Long
)