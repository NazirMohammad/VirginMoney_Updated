package com.example.virginmoney.data.repository

import com.example.virginmoney.data.remote.ApiRequest
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    val apiRequest: ApiRequest
) : VirginRepository {

    override suspend fun getPeople() = apiRequest.getPeople()
    override suspend fun getRooms() = apiRequest.getRooms()

}