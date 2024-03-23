package com.altafrazzaque.margh.views.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.altafrazzaque.margh.databinding.ItemQuotePostBinding
import com.altafrazzaque.margh.model.QuoteItem
import com.bumptech.glide.Glide

class QuoteAdapter constructor(val listener: ItemClickListener):
    ListAdapter<QuoteItem, QuoteAdapter.ViewHolder>(QuoteItemDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: ItemQuotePostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: QuoteItem, listener: ItemClickListener) {
            Glide.with(binding.root)
                .load(item.imageUrl)
                .into(binding.image)

            binding.btnSave.setOnClickListener {
                listener.save(item)
            }
            binding.btnDownload.setOnClickListener {
                listener.download(item)
            }
            binding.btnShare.setOnClickListener {
                listener.share(item)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemQuotePostBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}