package com.ninis.viewmodelsample.network

import com.ninis.viewmodelsample.util.createRetrofit

object RetrofitFactory {
    private const val baseUrl = "https://jsonplaceholder.typicode.com"

    val api: ApiService by lazy {
        createRetrofit(ApiService::class.java, baseUrl)
    }
}