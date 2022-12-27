package com.e.tragos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class DrinksAdapter:ListAdapter<Drinks,DrinksAdapter.ViewHolder>(DiffCallBack) {
    inner class ViewHolder(val view:View): RecyclerView.ViewHolder(view){
        val trago:TextView=view.findViewById(R.id.textViewDrink)
        val medidaTrago:TextView=view.findViewById(R.id.textViewDrinTh)
        val id:TextView=view.findViewById(R.id.textViewID)

        fun onBind(traguito:Drinks){
            trago.text=traguito.strDrink
            medidaTrago.text=traguito.strDrinkThumb
            id.text=traguito.idDrink
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val onBinTrago=getItem(position)
       holder.onBind(onBinTrago)

    }
    companion object DiffCallBack : DiffUtil.ItemCallback<Drinks>() {
        override fun areItemsTheSame(oldItem: Drinks, newItem: Drinks): Boolean {
            return oldItem.idDrink == newItem.idDrink
        }

        override fun areContentsTheSame(oldItem: Drinks, newItem: Drinks): Boolean {
            return oldItem == newItem
        }
    }



}