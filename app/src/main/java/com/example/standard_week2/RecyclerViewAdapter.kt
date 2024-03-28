package com.example.standard_week2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewAdapter(val itemList: Array<DonutItem>):
    RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    inner class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tv_name = itemView.findViewById<TextView>(R.id.tv_name_item)
        val tv_price = itemView.findViewById<TextView>(R.id.tv_price_item)
        val iv_item = itemView.findViewById<ImageView>(R.id.iv_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.tv_name.text = itemList[position].name
        holder.tv_price.text = itemList[position].price
        holder.iv_item.setImageResource(itemList[position].image)
    }

}