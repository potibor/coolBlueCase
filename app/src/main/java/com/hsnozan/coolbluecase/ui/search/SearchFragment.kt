package com.hsnozan.coolbluecase.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hsnozan.coolbluecase.R
import com.hsnozan.coolbluecase.databinding.FragmentSearchBinding
import com.hsnozan.coolbluecase.ui.search.adapter.SearchAdapter
import com.hsnozan.coolbluecase.util.afterTextChangedFlow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview

@OptIn(FlowPreview::class)
@AndroidEntryPoint
class SearchFragment : Fragment() {

    private val searchViewModel by viewModels<SearchViewModel>()
    private val searchAdapter = SearchAdapter()
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)
        binding.lifecycleOwner = this

        initBinding()
    }

    private fun initBinding() = with(binding) {
        viewModel = searchViewModel
        adapter = searchAdapter
        searchInputLayout.clearFocus()
        searchViewModel.observeSearchEdittext(searchEditText.afterTextChangedFlow())
    }
}