package com.example.shopper.ui.shopperlist

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shopper.R
import com.example.shopper.data.ShoppingItem

class ShopperAddItemDialog(context: Context,val addDialogListener: AddDialogListener) :AppCompatDialog(context) {

      lateinit var tv_add : TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_item_dialog)


        val tv_cancel = findViewById<TextView>(R.id.tv_cancel)

        val et_name = findViewById<EditText>(R.id.et_name)
        val et_amt= findViewById<EditText>(R.id.et_amt)

        tv_add = findViewById(R.id.tv_add)!!

        tv_add.setOnClickListener {

            var name= et_name?.text.toString()
            var amt= et_amt?.text.toString()

                if(name.isEmpty()  || amt.isEmpty()){
                    Toast.makeText(context,"please fill all the fields",Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

            var createdItem=ShoppingItem(name,amt.toInt())
            addDialogListener.addButtonClicked(createdItem)
            dismiss()
        }

        tv_cancel?.setOnClickListener(){
            cancel()
        }

    }

}