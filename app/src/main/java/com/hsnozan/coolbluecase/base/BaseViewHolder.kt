package com.hsnozan.coolbluecase.base

import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.ViewDataBinding

/**
 * Created by hsnozan on 15.01.2022.
 */
class BaseViewHolder<VB : ViewDataBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)