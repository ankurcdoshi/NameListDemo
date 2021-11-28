package com.plantix.namelistdemo.data.datasource

import kotlinx.coroutines.delay

class LocalDataSource: ILocalDataSource {

    private val nameList = mutableListOf<String>()

    override suspend fun insertNames(nameList: List<String>) {
        this.nameList.addAll(nameList)
    }

    override suspend fun loadNames(): List<String> {
        return nameList
    }
}