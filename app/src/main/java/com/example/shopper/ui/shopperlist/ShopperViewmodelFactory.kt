package com.example.shopper.ui.shopperlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shopper.data.ShopperRepository

class ShopperViewmodelFactory(private val repository: ShopperRepository) :
    ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return super.create(ShopperViewModel::class.java) as T
    }
}