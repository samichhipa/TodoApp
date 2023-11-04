package com.app.todo.Retrofit

import com.app.todo.models.response.Calls
import com.app.todo.models.response.Item
import retrofit2.Response

import retrofit2.http.GET

interface WebServices {

    @GET("demo-1/call")
    suspend fun getCalls(
    ): Response<List<Calls>>


    @GET("demo-1/buy")
    suspend fun getBuy(
    ): Response<List<Item>>


}