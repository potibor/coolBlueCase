package com.hsnozan.coolbluecase.base

/**
 * Created by hsnozan on 15.01.2022.
 */
interface ListAdapterItem {
    val id: String

    override fun equals(other: Any?): Boolean
}