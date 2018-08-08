package com.ninis.viewmodelsample.none_adapter

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninis.viewmodelsample.R
import com.ninis.viewmodelsample.network.RetrofitFactory
import kotlinx.android.synthetic.main.fragment_none_adapter.*

class NoneAdapterFragment: Fragment() {

    companion object {
        fun newInstance(): NoneAdapterFragment {
            return NoneAdapterFragment()
        }
    }

    private val viewModel : NoneAdapterViewModel by lazy {
        ViewModelProviders.of(this,
                object : ViewModelProvider.Factory {
                    @Suppress("UNCHECKED_CAST")
                    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                        return NoneAdapterViewModel(this@NoneAdapterFragment, RetrofitFactory.api) as T
                    }

                }
                ).get(NoneAdapterViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_none_adapter, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.loadData()
    }

    public fun setResponseTxt(txt: String) {
        tv_none_adapter_txt.text = txt
    }
}