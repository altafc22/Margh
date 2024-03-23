package com.altafrazzaque.margh.views.profile

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.altafrazzaque.margh.databinding.FragmentProfileBinding
import com.altafrazzaque.margh.util.openUrlInBrowser
import com.altafrazzaque.margh.views.QuotesViewModel
import com.altafrazzaque.margh.views.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class ProfileFragment : Fragment() {
    private val viewModel: QuotesViewModel by viewModels()

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val TAG = "ProfileFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.btnShare.setOnClickListener {
            val shareText = "🌟 Explore daily inspiration with our Quotes App! 🌟\n" +
                    "Discover a world of wisdom, motivation, and positivity through our hand-picked collection of quotes.\n" +
                    "Download our app 💬✨\n" +
                    "LINK"

            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }
            requireContext().startActivity(Intent.createChooser(shareIntent, "Share via"))
        }

        binding.btnContactUs.setOnClickListener {
            openUrlInBrowser("https://perfisys.com/contact.html", requireContext())
        }

        binding.btnAboutUs.setOnClickListener {
            openUrlInBrowser("https://perfisys.com/about.html", requireContext())
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.refreshQuotes()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}