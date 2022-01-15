package com.hsnozan.coolbluecase.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hsnozan.coolbluecase.data.model.ProductModel
import com.hsnozan.coolbluecase.data.model.ReviewInformationModel
import com.hsnozan.coolbluecase.data.model.ReviewSummaryModel
import com.hsnozan.coolbluecase.data.model.SearchModel
import com.hsnozan.coolbluecase.domain.SearchUseCase
import com.hsnozan.coolbluecase.ui.search.SearchViewModel
import com.hsnozan.coolbluecase.util.CoroutineTestRule
import com.hsnozan.coolbluecase.util.Either
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock

/**
 * Created by hsnozan on 15.01.2022.
 */
@RunWith(MockitoJUnitRunner.Silent::class)
@ExperimentalCoroutinesApi
class SearchViewModelTest {

    @get:Rule
    val mainCoroutineRule = CoroutineTestRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var searchUseCase: SearchUseCase

    @InjectMocks
    lateinit var searchViewModel: SearchViewModel

    @Test
    fun `Set error data when get products is called`() = runTest {
        whenever(searchUseCase.run(mock())).thenReturn(Either.Left(mockFailureModel()))

        searchViewModel.getProducts("")

        searchViewModel.onError.observeForever {
            Assertions.assertThat(it).isEqualTo("Fetch failed")
        }
    }

    @Test
    fun `Get products when response is successful`() = runTest {
        whenever(searchUseCase.run(mock())).thenReturn(Either.Right(mockSearchModel()))

        searchViewModel.getProducts("")

        searchViewModel.searchListLiveData.observeForever {
            Assertions.assertThat(it[0].productName).isEqualTo("Apple")
        }
    }

    private fun mockFailureModel() = Throwable("Fetch failed")

    private fun mockSearchModel() = SearchModel(products = listOf(mockProductModel()))
    private fun mockProductModel() = ProductModel(
        id = "",
        productName = "Apple",
        productImage = "",
        reviewInformation = mockReviewInformationModel()
    )

    private fun mockReviewInformationModel() =
        ReviewInformationModel(reviewSummary = ReviewSummaryModel(reviewAverage = 3.2F))
}