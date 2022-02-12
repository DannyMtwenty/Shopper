package com.example.shopper.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [ShoppingItem::class],
version = 1)


abstract class ShopperDatabase : RoomDatabase() {

    abstract fun getShopperDao() : ShopperDao

    //implementing singleton
    //to prevent many instances of shopperdatabase from being created at same time
    companion object {

        @Volatile    //only one thread writing to an instance
        private var instance : ShopperDatabase ? =null

        //create a lock obj
        private val Lock=Any()
        //fn to call when an instance of ShopperDatabase is created
        //synchronized ->only one thread sets the instance
        operator fun invoke (context: Context) = instance?: synchronized(Lock){
          instance?: createItemDatabase(context).also { instance=it }  //assign the instance to the method results
        }

        fun createItemDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,
        ShopperDatabase::class.java,"ShopperDb").build()
    }
}