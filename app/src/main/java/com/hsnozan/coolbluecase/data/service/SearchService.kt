package com.hsnozan.coolbluecase.data.service

import com.hsnozan.coolbluecase.data.model.SearchModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by hsnozan on 15.01.2022.
 */
interface SearchService {

    @GET(SEARCH_GIF)
    suspend fun searchProducts(
        @Query("query") query: String,
        @Query("page") page: Int
    ): SearchModel

    companion object {
        const val SEARCH_GIF = "search"
    }
}