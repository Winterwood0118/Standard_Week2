package com.example.standard_week2.adepter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.standard_week2.MainActivity
import com.example.standard_week2.R
import com.example.standard_week2.dataclass.DonutItem
import com.example.standard_week2.likeList


class DonutItemAdapter(val itemList: Array<DonutItem>):
    RecyclerView.Adapter<DonutItemAdapter.RecyclerViewHolder>() {

    inner class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tv_name = itemView.findViewById<TextView>(R.id.tv_name_item)
        val tv_price = itemView.findViewById<TextView>(R.id.tv_price_item)
        val iv_item = itemView.findViewById<ImageView>(R.id.iv_item)
        val iv_like = itemView.findViewById<ImageView>(R.id.iv_like_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_donut_item, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.tv_name.text = itemList[position].name
        holder.tv_price.text = itemList[position].price
        holder.iv_item.apply {
            setImageResource(itemList[position].image)
            setOnClickListener{
                (context as MainActivity).showDetail(position)
            }
        }
        holder.iv_like.apply {
            setBackgroundResource(
                if (likeList[position]) {
                    R.drawable.ic_heart_filled
                }else {
                    R.color.white
                }
            )
            setOnClickListener{
                if(likeList[position]) {
                    it.setBackgroundResource(R.color.white)
                }
                else {
                    it.setBackgroundResource(R.drawable.ic_heart_filled)
                }
                likeList[position] = !likeList[position]
            }
        }
    }
}