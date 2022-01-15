package com.hsnozan.coolbluecase.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hsnozan.coolbluecase.data.model.ProductModel
import com.hsnozan.coolbluecase.data.model.SearchModel
import com.hsnozan.coolbluecase.domain.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@HiltViewModel
class SearchViewModel @Inject constructor(private val searchUseCase: SearchUseCase) : ViewModel() {

    val searchedText = MutableLiveData<String?>()
    private val onError = MutableLiveData<String>()

    private val _searchListLiveData = MutableLiveData<SearchModel?>()
    val searchListLiveData: LiveData<List<ProductModel>> =
        Transformations.map(_searchListLiveData) { searchModel ->
            mutableListOf<ProductModel>().apply {
                searchModel?.let { addAll(it.products) }
            }
        }

    // Observe EditText
    @FlowPreview
    fun observeSearchEdittext(changedFlow: Flow<String>) {
        changedFlow.filterNot { it.isBlank() }
            .debounce(100)
            .distinctUntilChanged()
            .onEach { searchedTextValue ->
                requestSearch(searchedTextValue)
            }.launchIn(viewModelScope)
    }

    private fun requestSearch(searchedTextValue: String) = viewModelScope.launch {
        searchUseCase.run(SearchUseCase.Params(query = searchedTextValue, page = 1))
            .either(::handleError, ::updateSearchList)
    }

    private fun updateSearchList(searchModel: SearchModel) {
        _searchListLiveData.value = searchModel
    }

    // Error Handling
    private fun handleError(throwable: Throwable) {
        onError.value = throwable.message
    }
}