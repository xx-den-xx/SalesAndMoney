package com.bda.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.bda.database.models.ShoppingBucketDBO
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingBucketDao {

    @Query("SELECT * FROM buckets")
    fun getAllBuckets(): Flow<List<ShoppingBucketDBO>>

    @Insert
    suspend fun insert(shoppingBuckets: ShoppingBucketDBO)

    @Delete
    suspend fun remove(shoppingBuckets: ShoppingBucketDBO)

    @Query("DELETE FROM buckets")
    suspend fun clean()
}
