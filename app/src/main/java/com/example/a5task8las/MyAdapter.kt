package com.example.a5task8las

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class MyAdapter(var list:MutableList<Sher>, context: Context, var myInter: myInter):RecyclerView.Adapter<MyAdapter.VH>() {
    inner class VH(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        var txt2 = ""
        looop@for (i in list[position].name.toString()){
            txt2 += i.toString()
            if (txt2.length >= 27){
                txt2 += "..."
                break@looop
            }
        }
        holder.itemView.titleSher.text = txt2
        var txt = ""
        var num = 0
        var count = -1
        loop@for (i in list[position].txt.toString()){
            txt += i.toString()
            count ++
            if (i.toString() == "\n"){
                num ++
                count = -1
            }
            if (num == 2 && i.toString() == " "){
                txt += "..."
                break@loop
            }
            if (count > 30 && i.toString() == " "){
                txt += "\n"
                num ++
                count = -1
            }
        }
        holder.itemView.sherTxt.text = txt
        if (list[position].liked == false){
            holder.itemView.likedImg.visibility = View.INVISIBLE
        }else{
            holder.itemView.likedImg.visibility = View.VISIBLE
        }
        holder.itemView.setOnClickListener {
            myInter.onMyItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
interface myInter{
    fun onMyItemClick(position: Int)
}