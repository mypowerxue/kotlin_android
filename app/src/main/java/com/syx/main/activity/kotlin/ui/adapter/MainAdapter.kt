package com.syx.main.activity.kotlin.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.syx.main.activity.kotlin.R
import com.syx.main.activity.kotlin.model.bean.MainBean

class MainAdapter(list: ArrayList<MainBean.DataBean.ListBean>) : RecyclerView.Adapter<MainAdapter.Holder>(), View.OnClickListener, View.OnLongClickListener {

    private var mList = ArrayList<MainBean.DataBean.ListBean>()

    init {
        this.mList = list
    }

    private var context: Context? = null

    private var onItemClick: OnItemClick? = null

    private var onLongItemClick: OnLongItemClick? = null

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mImage: ImageView = itemView.findViewById(R.id.recycler_item_image)
        var mTitle: TextView = itemView.findViewById(R.id.recycler_item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val inflate : View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        inflate.setOnClickListener(this)
        inflate.setOnLongClickListener(this)
        return Holder(inflate)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.mTitle.text = mList[position].giftName
        Glide.with(context).load(mList[position].giftPic).into(holder.mImage)
        holder.itemView.tag = position
    }

    override fun getItemCount(): Int {
        return if (mList.isEmpty()) 0 else mList.size
    }


    //短按监听
    interface OnItemClick {
        fun setOnItemClick(v: View, position: Int)
    }

    override fun onClick(v: View) {
        if (onItemClick != null) {
            onItemClick!!.setOnItemClick(v, v.tag as Int)
        }
    }

    fun setOnItemClick(onItemClick: OnItemClick) {
        this.onItemClick = onItemClick
    }


    //长按监听
    interface OnLongItemClick {
        fun setOnLongItemClick(v: View, position: Int)
    }

    override fun onLongClick(v: View): Boolean {
        if (onLongItemClick != null) {
            onLongItemClick!!.setOnLongItemClick(v, v.tag as Int)
        }
        return false
    }

    fun setOnLongItemClick(onLongItemClick: OnLongItemClick) {
        this.onLongItemClick = onLongItemClick
    }
}
