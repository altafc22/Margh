package com.altafrazzaque.margh.views.home.adapter

import com.altafrazzaque.margh.model.QuoteItem
import javax.inject.Inject

interface ItemClickListener {
    fun save(item: QuoteItem)
    fun download(item:QuoteItem)
    fun share(item: QuoteItem)
}