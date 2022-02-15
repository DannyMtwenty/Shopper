package com.example.shopper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopper.data.ShopperDatabase
import com.example.shopper.data.ShopperRepository
import com.example.shopper.data.ShoppingItem
import com.example.shopper.other.ShopperAdapter
import com.example.shopper.ui.shopperlist.AddDialogListener
import com.example.shopper.ui.shopperlist.ShopperAddItemDialog
import com.example.shopper.ui.shopperlist.ShopperViewModel
import com.example.shopper.ui.shopperlist.ShopperViewmodelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.kodein.di.android.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class ShopperActivity : AppCompatActivity(),KodeinAware {
    lateinit var fab : FloatingActionButton

    override val kodein by kodein()
    private val shopperViewmodelFactory:ShopperViewmodelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        //get the viewmodel
        val shopperViewModel = ViewModelProviders.of(this,shopperViewmodelFactory).get(ShopperViewModel::class.java)

        val recycler_view=findViewById<RecyclerView>(R.id.shopperrecyclerview)

        // this creates a vertical layout Manager
        recycler_view.layoutManager = LinearLayoutManager(this)

        //creates an adapter
        val adapter= ShopperAdapter(listOf(),shopperViewModel)
        recycler_view.adapter=adapter



        //fill the adapter with items
        shopperViewModel.getAllItems().observe(this, Observer {
          adapter.ShopperItems=it     //it => all items in the list
            adapter.notifyDataSetChanged()
        })

        fab=findViewById(R.id.fab)

        fab.setOnClickListener{

            ShopperAddItemDialog(this,object : AddDialogListener{

                //to eexcecute when add is clicked
                override fun addButtonClicked(item: ShoppingItem) {
                  shopperViewModel.updateinsert(item)
                }

            }).show()


//         Toast.makeText(this,"lounch dialog",Toast.LENGTH_SHORT).show()
//            return@setOnClickListener
        }

    }
}