package com.bda.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bda.database.dao.ProductDao
import com.bda.database.dao.ShoppingBucketDao
import com.bda.database.models.ProductDBO
import com.bda.database.models.ShoppingBucketDBO
import com.bda.database.utils.TimeConverters

@Database(entities = [ShoppingBucketDBO::class, ProductDBO::class], version = 1)
@TypeConverters(TimeConverters::class)
abstract class SalesAndMoneyDatabase : RoomDatabase() {

    abstract fun shoppingBucketsDao(): ShoppingBucketDao

    abstract fun productDao(): ProductDao

}

fun SalesAndMoneyDatabase(context: Context): SalesAndMoneyDatabase {
    return Room.databaseBuilder(
        checkNotNull(context.applicationContext),
        SalesAndMoneyDatabase::class.java,
        "sales_and_money"
    ).build()
}