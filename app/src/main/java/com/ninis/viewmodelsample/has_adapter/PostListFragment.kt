package com.ninis.viewmodelsample.has_adapter

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninis.viewmodelsample.R
import com.ninis.viewmodelsample.has_adapter.adapter.PostListAdapter
import com.ninis.viewmodelsample.network.RetrofitFactory
import kotlinx.android.synthetic.main.fragment_has_adapter.*

class PostListFragment : Fragment() {

    companion object {
        fun newInstance(): PostListFragment {
            return PostListFragment()
        }
    }

    private val viewModel: PostListFragmentViewModel by lazy {
        ViewModelProviders.of(this,
                object : ViewModelProvider.Factory {
                    @Suppress("UNCHECKED_CAST")
                    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                        return PostListFragmentViewModel(RetrofitFactory.api) as T
                    }

                }
        ).get(PostListFragmentViewModel::class.java)
    }

    private val postListAdapter by lazy {
        PostListAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_has_adapter, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initView()

        viewModel.getResponsePost().observe(this, Observer { it ->
            if (it != null) {
                postListAdapter.viewModel.addItems(it)
            }
        })
        viewModel.loadData()
    }

    private fun initView() {
        rv_list.run {
            layoutManager = LinearLayoutManager(activity)
            adapter = postListAdapter
        }
    }
}