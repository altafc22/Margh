package com.altafrazzaque.margh.views.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.altafrazzaque.margh.model.QuoteItem

class QuoteItemDiffCallback : DiffUtil.ItemCallback<QuoteItem>() {

    override fun areItemsTheSame(oldItem: QuoteItem, newItem: QuoteItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: QuoteItem, newItem: QuoteItem): Boolean {
        return oldItem == newItem
    }

}

