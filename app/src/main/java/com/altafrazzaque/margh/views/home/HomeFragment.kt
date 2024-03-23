package com.altafrazzaque.margh.views.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.altafrazzaque.margh.R
import com.altafrazzaque.margh.databinding.FragmentHomeBinding
import com.altafrazzaque.margh.model.QuoteItem
import com.altafrazzaque.margh.util.downloadImage
import com.altafrazzaque.margh.util.shareImageWithMessage
import com.altafrazzaque.margh.views.QuotesViewModel
import com.altafrazzaque.margh.views.home.adapter.ItemClickListener
import com.altafrazzaque.margh.views.home.adapter.QuoteAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: QuotesViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    lateinit var adapter: QuoteAdapter

    companion object {
        private const val TAG = "HomeFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        adapter = QuoteAdapter(listener = object : ItemClickListener {
            override fun save(item: QuoteItem) {
               Timber.tag(TAG).i("Save: %s", item.imageUrl)
            }

            override fun download(item: QuoteItem) {
                Timber.tag(TAG).i("Download: %s", item.downloadUrl)
                downloadImage(item.id,item.imageUrl,requireContext())
            }

            override fun share(item: QuoteItem) {
                Timber.tag(TAG).i("Share: %s", item.imageUrl)
                item.downloadUrl?.let{
                    Toast.makeText(requireContext(),"Sharing image, please wait",Toast.LENGTH_LONG).show()
                    val message = "\uD83C\uDF1F Explore daily inspiration with our Quotes App! \uD83C\uDF1F\n" +
                            "Discover a world of wisdom, motivation, and positivity through our hand-picked collection of quotes.\n" +
                            "Download our app \uD83D\uDCAC✨ \n" +
                            " https://play.google.com/store/apps/details?id=com.codeinfinity.margh"

                    shareImageWithMessage(it,message, requireContext())
                } ?: run {
                    Toast.makeText(requireContext(),"Sharing image, please wait",Toast.LENGTH_LONG).show()
                }
            }

        })
        binding.recyclerView.adapter = adapter
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.refreshQuotes()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.refreshQuotes()

        viewModel.getQuotes().observe(viewLifecycleOwner) {
            Timber.tag(TAG).i("Data %s",it?.size)
            adapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}