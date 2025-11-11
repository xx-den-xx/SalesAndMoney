package com.bda.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.bda.database.models.ProductDBO
import com.bda.database.models.ShoppingBucketDBO
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun getAllProduct(): Flow<List<ProductDBO>>

    @Query("SELECT * FROM product WHERE ownerBucketsId=:ownerId")
    fun getAllProductByOwnerId(ownerId: Long): Flow<List<ProductDBO>>

    @Insert
    suspend fun insert(shoppingBuckets: ShoppingBucketDBO)

    @Delete
    suspend fun remove(shoppingBuckets: ShoppingBucketDBO)

    @Query("DELETE FROM product")
    suspend fun clean()
}
