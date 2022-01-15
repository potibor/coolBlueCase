package com.hsnozan.coolbluecase.data.repo

import com.hsnozan.coolbluecase.data.remote.SearchRemoteDataSource
import javax.inject.Inject

/**
 * Created by hsnozan on 15.01.2022.
 */
class SearchRepository @Inject constructor(
    private val remoteDataSource: SearchRemoteDataSource
) {
    suspend fun searchProducts(query: String, page: Int) = remoteDataSource.searchProducts(query, page)
}