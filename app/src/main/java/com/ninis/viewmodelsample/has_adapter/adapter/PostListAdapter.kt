package com.ninis.viewmodelsample.has_adapter.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ninis.viewmodelsample.R
import com.ninis.viewmodelsample.has_adapter.adapter.viewmodel.PostListAdapterViewModel

class PostListAdapter: RecyclerView.Adapter<PostItemViewHolder>() {

    val viewModel = PostListAdapterViewModel()

    init {
        viewModel.run {
            notifyDataSetChanged = this@PostListAdapter::notifyDataSetChanged
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_post_item_row, parent, false)

        return PostItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return viewModel.items.size
    }

    override fun onBindViewHolder(viewHolder: PostItemViewHolder, position: Int) {
        viewHolder.onBindViewHolder(viewModel.items[position])
    }
}