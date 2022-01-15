package com.hsnozan.coolbluecase.data.model

import com.hsnozan.coolbluecase.base.ListAdapterItem

/**
 * Created by hsnozan on 15.01.2022.
 */
data class SearchModel(val products: List<ProductModel>)

data class ProductModel(
    override val id: String,
    val productId: Int,
    val productName: String,
    val availabilityState: Int,
    val productImage: String,
    val reviewInformation: ReviewInformationModel
) : ListAdapterItem

data class ReviewInformationModel(val reviewSummary: ReviewSummaryModel)

data class ReviewSummaryModel(val reviewAverage: Float)