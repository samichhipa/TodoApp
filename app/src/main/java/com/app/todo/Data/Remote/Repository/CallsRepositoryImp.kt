package com.app.todo.DataSource.LocalDataSource.Remote.Repository

import com.app.todo.Domain.Repository.Repositories.CallsRepository
import com.app.todo.Models.Response.Calls
import com.app.todo.Retrofit.RetrofitClient
import retrofit2.Response

class CallsRepositoryImp : CallsRepository {
    override suspend fun getAllCalls(): Response<List<Calls>> {
        return RetrofitClient.apiService.getCalls()
    }
}