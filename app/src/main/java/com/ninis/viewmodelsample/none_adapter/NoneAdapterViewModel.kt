package com.ninis.viewmodelsample.none_adapter

import com.ninis.viewmodelsample.base.BaseViewModel
import com.ninis.viewmodelsample.base.ResponsePost
import com.ninis.viewmodelsample.network.ApiService
import com.ninis.viewmodelsample.util.applySingleIOToMainThreadSchedulers
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class NoneAdapterViewModel(val view: NoneAdapterFragment, val service: ApiService) : BaseViewModel() {
    fun loadData() {
        service.getPosts()
                .compose(applySingleIOToMainThreadSchedulers())
                .subscribe(object : SingleObserver<List<ResponsePost>> {
                    override fun onSuccess(list: List<ResponsePost>) {
                        if( !list.isEmpty() ) {
                            view.setResponseTxt(list.toString())
                        }
                    }

                    override fun onSubscribe(d: Disposable) {
                        disposable.add(d)
                    }

                    override fun onError(e: Throwable) {

                    }

                })
    }
}