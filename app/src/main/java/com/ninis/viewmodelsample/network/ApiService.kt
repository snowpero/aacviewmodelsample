package com.ninis.viewmodelsample.network

import com.ninis.viewmodelsample.base.ResponsePost
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    fun getPosts(): Single<List<ResponsePost>>
}