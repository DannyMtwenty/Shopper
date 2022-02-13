package com.example.shopper.ui.shopperlist

import androidx.lifecycle.ViewModel
import com.example.shopper.data.ShopperRepository
import com.example.shopper.data.ShoppingItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ShopperViewModel(private val repository: ShopperRepository) : ViewModel() {

//call repo methods with coroutines
    //lounch coroutines in main thread
    fun updateinsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.updateinsert(item)
}
    fun delete(item: ShoppingItem) =CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }
    fun getAllItems() =repository.getAllItems()
}