package com.ninis.viewmodelsample.has_adapter.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ninis.viewmodelsample.base.ResponsePost
import kotlinx.android.synthetic.main.layout_post_item_row.view.*

class PostItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun onBindViewHolder(item: ResponsePost?) {
        itemView.tv_txt.text = item?.title
    }
}