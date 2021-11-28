package com.plantix.namelistdemo.data.repository

interface INameListRepository {
    suspend fun loadNames(): List<String>
}