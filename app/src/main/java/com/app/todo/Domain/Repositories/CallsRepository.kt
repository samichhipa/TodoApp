package com.app.todo.Domain.Repository.Repositories

import androidx.lifecycle.LiveData
import com.app.todo.Models.Resource
import com.app.todo.Models.Response.Calls
import com.app.todo.Models.Response.Item
import retrofit2.Response

interface CallsRepository {

    suspend fun getAllCalls(): Response<List<Calls>>


}