package com.app.todo.Domain.Repository.Repositories

import com.app.todo.models.response.Calls
import retrofit2.Response

interface CallsRepository {

    suspend fun getAllCalls(): Response<List<Calls>>


}