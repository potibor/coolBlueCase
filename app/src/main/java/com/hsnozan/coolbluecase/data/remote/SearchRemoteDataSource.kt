package com.hsnozan.coolbluecase.data.remote

import com.hsnozan.coolbluecase.data.service.SearchService
import javax.inject.Inject

/**
 * Created by hsnozan on 15.01.2022.
 */
class SearchRemoteDataSource @Inject constructor(
    private val searchService: SearchService
) {
    suspend fun searchProducts(query: String, page: Int) = searchService.searchProducts(query, page)
}