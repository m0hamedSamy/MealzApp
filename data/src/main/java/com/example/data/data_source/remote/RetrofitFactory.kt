package com.example.data.data_source.remote

import com.example.data.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitFactory {
    private const val CONNECT_TIMEOUT_SECONDS = 7L

    private val loggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BASIC)

    private val httpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .readTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .writeTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.MEALS_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()

    fun <T> createService(serviceClass: Class<T>): T = retrofit.create(serviceClass)
}