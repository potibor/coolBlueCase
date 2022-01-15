package com.hsnozan.coolbluecase.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hsnozan.coolbluecase.data.model.ProductModel
import com.hsnozan.coolbluecase.data.model.ReviewInformationModel
import com.hsnozan.coolbluecase.data.model.ReviewSummaryModel
import com.hsnozan.coolbluecase.data.model.SearchModel
import com.hsnozan.coolbluecase.data.remote.SearchRemoteDataSource
import com.hsnozan.coolbluecase.data.repo.SearchRepository
import com.hsnozan.coolbluecase.util.CoroutineTestRule
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by hsnozan on 15.01.2022.
 */
@RunWith(MockitoJUnitRunner.Silent::class)
@ExperimentalCoroutinesApi
class SearchRepositoryTest {

    @get:Rule
    val mainCoroutineRule = CoroutineTestRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var remoteDataSource: SearchRemoteDataSource

    @InjectMocks
    lateinit var searchRepository: SearchRepository

    @Test
    fun `Set data when search Products is called`() = runTest {
        whenever(remoteDataSource.searchProducts("", 0)).thenReturn(mockSearchModel())
        val response = remoteDataSource.searchProducts("", 0)

        searchRepository.searchProducts("", 0)

        assertThat(response.products[0].productName).isEqualTo("CoolBlue will offer a job to Ozan")
    }

    private fun mockSearchModel() = SearchModel(products = listOf(mockProductModel()))
    private fun mockProductModel() = ProductModel(
        id = "",
        productName = "CoolBlue will offer a job to Ozan",
        productImage = "",
        reviewInformation = mockReviewInformationModel()
    )

    private fun mockReviewInformationModel() =
        ReviewInformationModel(reviewSummary = ReviewSummaryModel(reviewAverage = 3.2F))
}