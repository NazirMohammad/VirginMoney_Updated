package com.example.virginmoney.di

import com.example.virginmoney.data.remote.ApiDetails
import com.example.virginmoney.data.remote.ApiRequest
import com.example.virginmoney.data.repository.RepositoryImp
import com.example.virginmoney.data.repository.VirginRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class VirginModule {

    @Provides
    fun ProvideGson(): Gson {
        return Gson()

    }

    @Provides
    fun ProvideOkhttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }

            )
            .build()

    }

    @Provides
    @Singleton
    fun ProvidesRetrofit(
        gson: Gson,
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()

    }


    @Provides
    fun provideAPI(
        retrofit: Retrofit
    ): ApiRequest {
        return retrofit.create(ApiRequest::class.java)
    }


    @Provides
    fun ProvideRepository(apiRequest: ApiRequest): VirginRepository {
        return RepositoryImp(apiRequest)


    }
}
