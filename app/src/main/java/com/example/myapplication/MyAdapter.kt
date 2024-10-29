package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.LinkedList
import java.util.Stack

class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val items = ArrayList<Int>()
    private var stack = Stack<Int>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            delItem(position)
        }
    }

    fun getItems() : ArrayList<Int> { return items }


    fun delItem(pos : Int) {
        stack.add(items[pos])
        items.removeAt(pos)
        notifyDataSetChanged()
    }

    fun addItem(item : Int) {
        if (!stack.empty()) {
            items.add(stack.pop())
        } else {
            items.add(item)
        }
        notifyDataSetChanged()
    }

    fun setItem(list : List<Int>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }



}