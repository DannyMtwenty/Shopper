package com.example.shopper

import android.app.Application
import com.example.shopper.data.ShopperDatabase
import com.example.shopper.data.ShopperRepository
import com.example.shopper.ui.shopperlist.ShopperViewmodelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ShopperApplication: Application(),KodeinAware {

    //implement methods
    //lazy allows  to use application context during binding time in that block
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ShopperApplication))

        //things to inject
        //instatiate classes
        bind() from singleton { ShopperDatabase (instance()) }
        bind() from singleton { ShopperRepository (instance()) }

        //provider  =>ShopperViewmodelFactory to be used in shopper activity
        bind() from provider { ShopperViewmodelFactory (instance()) }


    }

}