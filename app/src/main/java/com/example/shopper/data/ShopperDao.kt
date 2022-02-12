package com.example.shopper.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShopperDao {
    //update or insert the item
    @Insert(onConflict = OnConflictStrategy.REPLACE)

    //cannot write to db on main thread
    suspend fun updateinsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_item")
    fun getAllItems() : LiveData<List<ShoppingItem>>

}