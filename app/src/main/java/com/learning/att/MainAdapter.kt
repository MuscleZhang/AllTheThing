package com.learning.att

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class MainAdapter(var mContext: Context) : RecyclerView.Adapter<MainViewHolder>() {
    lateinit var data : List<String>
    lateinit var itemListener: Array<ItemClickCallBack>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.item_main_recycler, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.mName.text = data[position]
        if(position == data.size - 1) {
            holder.divider.visibility = View.GONE
        }
        holder.itemView.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                itemListener[position].onItemClick()
            }
        })
    }

    override fun getItemCount(): Int {
        return data.size
    }

}

class MainViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    var mName: TextView = item.findViewById(R.id.tv_name)
    var divider: View = item.findViewById(R.id.divider)
//    var item = itemView

}

interface ItemClickCallBack{
    fun onItemClick()
}