package com.plantix.namelistdemo.data.datasource

import kotlinx.coroutines.delay

class RemoteDataSource: IRemoteDataSource {

    override suspend fun loadNames(): List<String> {
        delay(3000)
        return listOf("Rakesh Hathiwala", "Hem Vora", "Ronit Zariwala", "Yogad Asher",
            "Harshal Sultana", "Panini Ravipati", "Sharadchandra Chittibabu", "Rehmat Gupte",
            "Ganesh Nivedita", "Vasistha Yadavalli", "Kambodi Gambhir", "Ekram Phadkar",
            "Vedprakash Ujjaval")
    }
}