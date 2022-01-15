package com.hsnozan.coolbluecase.di

import android.content.Context
import com.google.gson.GsonBuilder
import com.hsnozan.coolbluecase.BuildConfig
import com.hsnozan.coolbluecase.data.service.SearchService
import com.hsnozan.coolbluecase.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by hsnozan on 15.01.2022.
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(client)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        interceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient().newBuilder().apply {
            connectTimeout(Constants.Network.CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
            readTimeout(Constants.Network.READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            writeTimeout(Constants.Network.WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            addInterceptor(interceptor)
        }.build()
    }

    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor {
        return Interceptor {
            val requestBuilder = it.request().newBuilder()
            it.proceed(requestBuilder.build())
        }
    }

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext appContext: Context): Context {
        return appContext
    }

    @Provides
    @Singleton
    fun provideLinkApi(retrofit: Retrofit): SearchService {
        return retrofit.create(SearchService::class.java)
    }
}