package com.hsnozan.coolbluecase.domain

import com.hsnozan.coolbluecase.data.model.SearchModel
import com.hsnozan.coolbluecase.data.repo.SearchRepository
import com.hsnozan.coolbluecase.util.UseCase
import javax.inject.Inject

/**
 * Created by hsnozan on 15.01.2022.
 */
class SearchUseCase @Inject constructor(
    private val repository: SearchRepository
) : UseCase<SearchModel, SearchUseCase.Params>() {

    override suspend fun buildUseCase(params: Params): SearchModel {
        return repository.searchProducts(params.query, params.page)
    }

    data class Params(
        val query: String,
        val page: Int
    )
}