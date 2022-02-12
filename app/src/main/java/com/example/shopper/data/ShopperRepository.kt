package com.example.shopper.data

import com.example.shopper.data.ShopperDatabase

class ShopperRepository(private val db:ShopperDatabase) {

    //implement db methods defined in dao
    suspend fun updateinsert (item: ShoppingItem) = db.getShopperDao().updateinsert(item)
    suspend fun delete (item: ShoppingItem) = db.getShopperDao().delete(item)
    fun getAllItems () =db.getShopperDao().getAllItems()
}