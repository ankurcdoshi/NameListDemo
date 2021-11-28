package com.plantix.namelistdemo.data.repository

import com.plantix.namelistdemo.data.datasource.ILocalDataSource
import com.plantix.namelistdemo.data.datasource.IRemoteDataSource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class NameListRepository(private val localSrc: ILocalDataSource,
                         private val remoteSrc: IRemoteDataSource
): INameListRepository {

    override suspend fun loadNames(): List<String> {
        var resp = localSrc.loadNames()
        if (resp.isEmpty()) {
            resp = remoteSrc.loadNames()
            GlobalScope.async {
                localSrc.insertNames(resp)
            }
        }
        return resp
    }
}