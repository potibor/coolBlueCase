package com.hsnozan.coolbluecase.ui.search.adapter

import com.hsnozan.coolbluecase.R
import com.hsnozan.coolbluecase.base.BaseListAdapter
import com.hsnozan.coolbluecase.data.model.ProductModel
import com.hsnozan.coolbluecase.databinding.ItemSearchBinding
import com.hsnozan.coolbluecase.util.load

/**
 * Created by hsnozan on 15.01.2022.
 */

class SearchAdapter : BaseListAdapter<ItemSearchBinding, ProductModel>() {

    override val layoutRes = R.layout.item_search

    override fun bind(
        binding: ItemSearchBinding,
        item: ProductModel
    ) = with(binding) {
        itemImageView.load(item.productImage)
        brandNameTextView.text = item.productName
        ratingBar.rating = item.reviewInformation.reviewSummary.averageRating
    }
}