package com.plantix.namelistdemo.data.datasource

interface IRemoteDataSource {
    suspend fun loadNames(): List<String>
}