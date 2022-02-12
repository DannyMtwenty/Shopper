package com.example.shopper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopper.data.ShopperDatabase
import com.example.shopper.data.ShopperRepository
import com.example.shopper.data.ShoppingItem
import com.example.shopper.other.ShopperAdapter
import com.example.shopper.ui.shopperlist.ShopperViewModel
import com.example.shopper.ui.shopperlist.ShopperViewmodelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shopperdb=ShopperDatabase(this)
        val shopperrepo=ShopperRepository(shopperdb)
        val shopperViewmodelFactory=ShopperViewmodelFactory(shopperrepo)

        //get the viewmodel
        val shopperViewModel = ViewModelProviders.of(this,shopperViewmodelFactory).get(ShopperViewModel::class.java)

        val recycler_view=findViewById<RecyclerView>(R.id.shopperrecyclerview)

        // this creates a vertical layout Manager
        recycler_view.layoutManager = LinearLayoutManager(this)

        //creates an adapter
        recycler_view.adapter= ShopperAdapter(List<ShoppingItem>,shopperViewModel)

    }
}