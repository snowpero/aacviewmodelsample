package com.ninis.viewmodelsample.has_adapter.adapter.viewmodel

import com.ninis.viewmodelsample.base.BaseViewModel
import com.ninis.viewmodelsample.base.ResponsePost

class PostListAdapterViewModel : BaseViewModel() {
    lateinit var showDetailPage: (postId: Long) -> Unit

    lateinit var notifyDataSetChanged: () -> Unit

    val items = ArrayList<ResponsePost>()

    public fun addItems(listData: List<ResponsePost>) {
        if (!items.isEmpty())
            items.clear()

        items.addAll(listData)
        notifyDataSetChanged()
    }
}