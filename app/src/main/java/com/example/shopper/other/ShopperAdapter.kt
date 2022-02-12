package com.example.shopper.other

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopper.R
import com.example.shopper.data.ShoppingItem
import com.example.shopper.ui.shopperlist.ShopperViewModel

class ShopperAdapter(
    var ShopperItems:List<ShoppingItem>,
    private val shopperViewModel: ShopperViewModel) : RecyclerView.Adapter<ShopperAdapter.shopperViewHolder>() {

        //viewholder class
         inner class shopperViewHolder(itemview : View)  : RecyclerView.ViewHolder(itemview){
            val tvname =itemview.findViewById<TextView>(R.id.txt_itemname)
            var tvamt =itemview.findViewById<TextView>(R.id.txt_amount)
            var icplus =itemview.findViewById<ImageView>(R.id.img_plus)
            var icminus =itemview.findViewById<ImageView>(R.id.img_minus)
            var icdelete =itemview.findViewById<ImageView>(R.id.img_delete)
         }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): shopperViewHolder {
        //layout to inflate to the recycler view
        val view =LayoutInflater.from(parent.context).inflate(R.layout.shopper_item,parent,false)
         return shopperViewHolder(view)
    }

    override fun onBindViewHolder(holder: shopperViewHolder, position: Int) {
        //set values or listeners for the views
        var currentShopperItem=ShopperItems[position]

        holder.tvname.text=currentShopperItem.itemName
        holder.tvamt.text="${currentShopperItem.amount}"

        holder.icplus.setOnClickListener {
            currentShopperItem.amount++
            shopperViewModel.updateinsert(currentShopperItem)
        }
        holder.icminus.setOnClickListener {
            if(currentShopperItem.amount > 0){
                currentShopperItem.amount--
                shopperViewModel.updateinsert(currentShopperItem)
            }

        }
        holder.icdelete.setOnClickListener {
            shopperViewModel.delete(currentShopperItem)
        }


    }

    override fun getItemCount(): Int {
        return ShopperItems.size
    }
}