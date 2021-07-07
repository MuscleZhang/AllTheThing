package com.learning.att

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class MainAdapter(var mContext: Context) : RecyclerView.Adapter<MainViewHolder>() {
    var data = listOf("test", "测试")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.item_main_recycler, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.mName.text = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mName  = itemView.findViewById<TextView>(R.id.tv_name)

}