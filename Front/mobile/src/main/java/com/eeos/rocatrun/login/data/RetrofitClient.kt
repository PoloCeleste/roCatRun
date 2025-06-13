// RetrofitClient.kt
package com.eeos.rocatrun.login.data

import android.content.Context
import com.eeos.rocatrun.R
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private lateinit var apiServiceInstance: ApiService

    fun initialize(context: Context) {
        val apiAddress = context.getString(R.string.api_address) + "/"

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        apiServiceInstance = Retrofit.Builder()
            .baseUrl(apiAddress)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    val apiService: ApiService
        get() = apiServiceInstance
}
