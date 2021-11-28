package com.plantix.namelistdemo.data.datasource

interface ILocalDataSource {
    suspend fun insertNames(nameList: List<String>)
    suspend fun loadNames(): List<String>
}