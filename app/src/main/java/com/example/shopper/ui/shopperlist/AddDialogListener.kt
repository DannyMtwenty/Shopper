package com.example.shopper.ui.shopperlist

import com.example.shopper.data.ShoppingItem

//to be implemented in the main activity
interface AddDialogListener {
    fun addButtonClicked(item: ShoppingItem)
}