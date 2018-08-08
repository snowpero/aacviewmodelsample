package com.ninis.viewmodelsample.has_adapter

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.ninis.viewmodelsample.base.BaseViewModel
import com.ninis.viewmodelsample.base.ResponsePost
import com.ninis.viewmodelsample.network.ApiService
import com.ninis.viewmodelsample.util.applySingleIOToMainThreadSchedulers
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class PostListFragmentViewModel(val service: ApiService): BaseViewModel() {

    private val responsePost: MutableLiveData<List<ResponsePost>> by lazy {
        MutableLiveData<List<ResponsePost>>()
    }

    fun loadData() {
        service.getPosts()
                .compose(applySingleIOToMainThreadSchedulers())
                .subscribe(object : SingleObserver<List<ResponsePost>> {
                    override fun onSuccess(list: List<ResponsePost>) {
                        if( !list.isEmpty() ) {
                            responsePost.value = list
                        }
                    }

                    override fun onSubscribe(d: Disposable) {
                        disposable.add(d)
                    }

                    override fun onError(e: Throwable) {

                    }

                })
    }

    fun getResponsePost(): LiveData<List<ResponsePost>> {
        return responsePost
    }
}